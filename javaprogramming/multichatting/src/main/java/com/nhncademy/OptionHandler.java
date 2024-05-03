package com.nhncademy;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class OptionHandler {
    static int portNum;
    static String addressStr;
    public static void main(String[] args) {
        Options options = new Options(); // 옵션 객체 생성
        Option helpOption = new Option("h", false, "Help"); // 도움말 옵션 생성

        options.addOption(helpOption); // 도움말 옵션 추가

        Option serverOpen = Option.builder("l") // 새로 정의한 옵션 a -> add id - 사용자 접속 차단 등록
                .longOpt("server")
                .argName("path")
                .desc("Server Open")
                .build(); // 옵션을 생성하고 옵션의 속성 설정

        options.addOption(serverOpen); // 사용자 정의 옵션 추가해주기

        Option port = Option.builder("p") 
                .longOpt("port")
                .argName("path")
                .hasArg()
                .desc("Port")
                .build();

        options.addOption(port);

        Option host = Option.builder("H") 
                .longOpt("host")
                .argName("path")
                .hasArg()
                .desc("Host")
                .build();

        options.addOption(host);

        CommandLineParser parser = new DefaultParser(); // 명령줄 인자 파싱
        try {
            CommandLine commandLine = parser.parse(options, args); // 명령줄 옵션을 파싱하고 commandLine 객체를 얻는다

            if (commandLine.hasOption(helpOption.getOpt())) { // hasoption:옵션이 잘 전달되었는지 확인
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("recoder", options);
            }

            if (commandLine.hasOption("p")) {
                String portStr = commandLine.getOptionValue(port.getOpt());
                portNum = Integer.parseInt(portStr);
            } else {
                portNum = 1234;
            }

            if (commandLine.hasOption("H")) {
                addressStr = commandLine.getOptionValue(host.getOpt());                
            } else {
                addressStr = "localhost";
            }

            if (commandLine.hasOption("l")) {
                MultiChatServer server = new MultiChatServer(portNum);
                Thread thread = new Thread(server);
                thread.start();
            } else {
                MultiChatClient client = new MultiChatClient(addressStr,portNum);
                Thread thread = new Thread(client);
                thread.start();
            }


        } catch (ParseException e) { // 예외처리
            System.err.println(e.getMessage());
            System.exit(0);
        }

    }
}
