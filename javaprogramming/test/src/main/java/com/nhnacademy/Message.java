package com.nhnacademy;

import java.util.UUID;

public class Message {
    private String id;
    private String info;
    private Message message;
    private int priority;

    public Message(String info) {
        this.id = UUID.randomUUID().toString();
        this.info = info;
    }

    public Message(Message message, int priority) {
        this.message = message;
        this.priority = priority;
    }

    public int compareTo(Message otherMessage) {
        return Integer.compare(otherMessage.priority, this.priority);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getId() {
        return id;
    }

}
