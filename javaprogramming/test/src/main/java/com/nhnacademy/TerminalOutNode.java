package com.nhnacademy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TerminalOutNode extends ActiveNode implements Consumer, Runnable{
    private Pipe inputPipe;
    Logger logger = LogManager.getLogger();

    
    public TerminalOutNode(String id, String name) {
        super(name);
    }

    @Override
    public void run() {
        while (isActive()) {
           
            perform();
            
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                logger.error("에러 : {}", e.getMessage());
                Thread.currentThread().interrupt(); 
            }
        }
        logger.info("Terminated");
        terminated(); 
    }


    @Override
    public void receiveMessage(String message) {
        
        logger.info("받은 메시지 : {}" , message);
    }

    @Override
    public void receiveNumber(int number) {
        
        logger.info("받은 숫자 : {}", number);
    }

    @Override
    public void inputPipe(Pipe pipe) {
        this.inputPipe(pipe);
    }
}
