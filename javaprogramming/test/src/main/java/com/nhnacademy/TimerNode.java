package com.nhnacademy;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimerNode extends ActiveNode implements Producer, Runnable {
    private int timeInterval;
    private Timer timer;
    Logger logger = LogManager.getLogger();
    
    
    public TimerNode(String id, String name, int timeInterval, Timer timer) {
        super(name);
        this.timeInterval = timeInterval;
        this.timer = timer;
    }
    
   @Override 
    public void run() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String message = produceMessage();
                // outputPipe(message); // ?????
            }
        }, 0, timeInterval);
    }


    @Override
    public String produceMessage() {
        return "";
    }


    @Override
    public int produceNumber() {

        throw new UnsupportedOperationException("Unimplemented method 'produceNumber'");
    }

    @Override
    public void outputPipe(Pipe pipe) {
       String message = produceMessage();
       // pipe.sendMessage(message, priority); // ????
    }
}
