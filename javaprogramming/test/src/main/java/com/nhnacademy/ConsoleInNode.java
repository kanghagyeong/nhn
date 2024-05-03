package com.nhnacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleInNode extends ActiveNode implements Producer, Runnable {
    private Pipe outputPipe;

    public ConsoleInNode(String id, String name) {
        super(name);
    }

    @Override
    public void run() {
        try ( BufferedReader input = new BufferedReader(new InputStreamReader(System.in));) {
            while (!Thread.interrupted()) {
           
                String line;
    
                if ((line = input.readLine()).equals("exit")) {
                    break;
                }
    
                try {
                    int number = Integer.parseInt(line);
                    outputPipe.produceNumber(number);
    
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
    
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public String produceMessage() {
        return "message";

    }

    @Override
    public void outputPipe(Pipe pipe) {
        this.outputPipe(pipe);
    }

    @Override
    public int produceNumber() {
        throw new UnsupportedOperationException("Unimplemented method 'produceNumber'");
    }
}
