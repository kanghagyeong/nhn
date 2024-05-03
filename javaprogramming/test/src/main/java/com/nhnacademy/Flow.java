package com.nhnacademy;

import java.util.ArrayList;
import java.util.List;

public class Flow {
   
    private List<Node> nodes;
    private List<Pipe> pipes;

    public Flow() {
        nodes = new ArrayList<>();
        pipes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addPipe(Pipe pipe) {
        pipes.add(pipe);
    }

    public void connect(Node producer, Node consumer, Pipe pipe) {
        producer.setOutputPipe(pipe);
        consumer.setInputPipe(pipe);
    }

}

    

