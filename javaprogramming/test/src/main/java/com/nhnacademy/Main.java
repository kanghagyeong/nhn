package com.nhnacademy;

import java.util.Timer;

public class Main {
    public static void main(String[] args) {
           
        Flow flow = new Flow();
       
        ConsoleInNode consoleInNode = new ConsoleInNode("ConsoleInNode", "ConsoleInput");
        TerminalOutNode terminalOutNode = new TerminalOutNode("TerminalOutNode", "TerminalOutput");
        TimerNode timerNode = new TimerNode("TimerNode", "Timer", 1000, new Timer());
        FunctionNode functionNode = new FunctionNode("FunctionNode", "Function");

      
        flow.addNode(consoleInNode);
        flow.addNode(terminalOutNode);
        flow.addNode(timerNode);
        flow.addNode(functionNode);

        
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();

        flow.addPipe(pipe1);
        flow.addPipe(pipe2);
        flow.addPipe(pipe3);

 
        flow.connect(consoleInNode, functionNode, pipe1);
        flow.connect(functionNode, terminalOutNode, pipe2);
        flow.connect(timerNode, functionNode, pipe3);

        
        Thread consoleInThread = new Thread(consoleInNode);
        Thread terminalOutThread = new Thread(terminalOutNode);
        Thread timerThread = new Thread(timerNode);
        Thread functionThread = new Thread(functionNode);

        consoleInThread.start();
        terminalOutThread.start();
        timerThread.start();
        functionThread.start();


        

       
        try {
            consoleInThread.join();
            terminalOutThread.join();
            timerThread.join();
            functionThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
