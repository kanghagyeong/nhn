package com.nhnacademy;

import java.util.UUID;

public class Node {
    private String id;
    private String name;
    private Pipe outputPipe;
    private Pipe inputPipe;

    public Node(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setOutputPipe(Pipe pipe) {
        this.outputPipe = outputPipe;
    }

    public void setInputPipe(Pipe pipe) {
        this.inputPipe = inputPipe;
    }

}
