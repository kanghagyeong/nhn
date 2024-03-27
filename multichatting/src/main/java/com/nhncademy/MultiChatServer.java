package com.nhncademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.json.JSONObject;

public class MultiChatServer implements Runnable {
    int port;
    boolean monitorSet = true;
    private static int id = 0;
    List<String> denyList = new ArrayList<>();
    Queue<String> responseList = new LinkedList<>();
    List<String> client_list = new ArrayList<>();

    public MultiChatServer(int port) {
        this.port = port;
    }

    public int getId() {
        return ++id;
    }

    public void commandHandler(String command) {
        String[] addList = command.split(" ");
        if (addList.length == 1) {
            System.out.println("접속 사용자 목록 : ");
            for (String clientId : client_list) {
                System.out.println(clientId);
            }
        } else if (addList.length == 2) {
            if (addList[0].equals("send")) {
                client_list.remove(addList[2]);
                System.out.println("강퇴");
            } else if (addList[1].equals("monitor")) {
                if (addList[1].equals("on")) {
                    monitorSet = true;
                    System.out.println("사용자 감시 설정 모드입니다.");
                } else if (addList[1].equals("off")) {
                    monitorSet = false;
                    System.out.println("사용자 메세지 감시 설정이 해제되었습니다.");
                }
            }
        } else if (addList.length == 3) {
            if (addList[1].equals("add")) {
                denyList.add(addList[2]);
                System.out.println(addList[2] + "사용자 접속 차단 등록");
            } else if (addList[1].equals("deny")) {
                denyList.remove(addList[2]);
                System.out.println(addList[2] + "사용자 접속 차단 해제");
            }
        } else if (addList.length == 4) {
            // 로그 출력
        } else {
            System.out.println("잘못된 입력입니다 !");
        }
    }

    private JSONObject stringToJSON(String line) {
        String[] message = line.split(" ");
        int id = getId();
        String type = message[0];
        String clientId = message[1];

        JSONObject object = new JSONObject();
        object.put("id", id);
        object.put("type", type);
        object.put("clientId", clientId);

        return object;
    }

    private void requestConnect(JSONObject response) {
        String clientId = response.getString("clientId");
        if (denyList.contains(clientId)) {
            response.put("reponse", "deny");
            responseList.add(response.toString(1));
        } else {
            response.put("reponse", "ok");
            responseList.add(response.toString(1));
            client_list.add(clientId);
        }
    }

    @Override
    public void run() {
        List<Thread> clientHandlerList = new LinkedList<>();
        List<MultiNC> netcatList = new LinkedList<>();

        Thread consoleInputAgent = new Thread(() -> { // 서버에 콘솔 입력을 받는다 (관리느낌)
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                String line;
                while ((line = input.readLine()) != null) {
                    commandHandler(line);
                    synchronized (netcatList) {
                        for (MultiNC netcat : netcatList) {
                            netcat.send(line + "\n");
                        }
                    }
                }
            } catch (IOException e) {
            }
        });

        Thread inputAgent = new Thread(() -> { // 서버에서 클라이언트로 데이터를 보낸다
            while (!Thread.currentThread().interrupted()) {
                while (!responseList.isEmpty()) {
                    String message = responseList.poll();
                    synchronized (netcatList) {
                        for (MultiNC multiNC : netcatList) {
                            multiNC.send(message + "\n");
                        }
                    }
                }
            }
        });

        Thread outputAgent = new Thread(() -> { // 클라이언트에서 보낸 데이터를 서버가 받는다 
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (netcatList) {
                    for (MultiNC netcat : netcatList) {
                        if (!netcat.isEmptyReceiveQueue()) {
                            String line = netcat.receive();
                            JSONObject response = stringToJSON(line);

                            if (monitorSet) {
                                System.out.println(response);
                            }

                            if (response.getString("type").equals("connect")) {
                                requestConnect(response);
                            } else if(response.getString("type").equals("message")) {

                            }
                        }
                    }
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignore) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        consoleInputAgent.start();
        inputAgent.start();
        outputAgent.start();

        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("서버에 접속되었습니다 !");
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    MultiNC netcat = new MultiNC(serverSocket.accept());
                    Thread thread = new Thread(netcat);
                    thread.start();
                    clientHandlerList.add(thread);
                    netcatList.add(netcat);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
