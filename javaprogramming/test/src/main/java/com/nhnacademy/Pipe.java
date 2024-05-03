package com.nhnacademy;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.UUID;

public class Pipe {
    private String id;
    private String message;
    private int maxCount;
    Queue<Message> messageQueue = new PriorityQueue<>();

    public Pipe() {
        this.id = UUID.randomUUID().toString();
        
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        
    }

    public void saveMessage(Message message) {
        messageQueue.add(message);

        while (messageQueue.size() > maxCount) {
            messageQueue.poll();
        }
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;

        while (messageQueue.size() > maxCount) {
            messageQueue.remove(0);
        }
    }

    public void sendMessage(Message message, int priority) {
        Message messages = new Message(message, priority);
        saveMessage(messages);
    }

    public void produceNumber(int number) {
        throw new UnsupportedOperationException("Unimplemented method 'produceNumber'");
    }

}
