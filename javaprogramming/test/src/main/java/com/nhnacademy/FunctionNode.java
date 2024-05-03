package com.nhnacademy;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FunctionNode extends ActiveNode implements Producer, Consumer, Runnable {
    private List<Pipe> inputPipes;
    private List<Pipe> outputPipes;
    Logger logger = LogManager.getLogger();


    public FunctionNode(String id, String name) {
        super(name);
        this.inputPipes = new ArrayList<>();
        this.outputPipes = new ArrayList<>();
    }

    @Override
    public void run() {
        while (isActive()) {
           for (Pipe inputPipe : inputPipes) {
            String inputData = inputPipe.getMessage();
            String processData = processData(inputData);
           }

           for (Pipe outPipe : outputPipes) {
            outPipe.sendMessage(null, 0);
           }
        }
       
    }


    private String processData(String inputData) {
       return inputData;
    }

    @Override
    public void receiveMessage(String message) {
        this.receiveMessage(message);
    }

    @Override
    public void receiveNumber(int number) {
        this.receiveNumber(number);
    }

    @Override
    public String produceMessage() {
       return "message";
    }

    @Override
    public void inputPipe(Pipe pipe) {

    }

    @Override
    public void outputPipe(Pipe pipe) {

    }

    @Override
    public int produceNumber() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'produceNumber'");
    }

    }
