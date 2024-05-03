package com.nhnacademy;

public interface Producer {
    String produceMessage();
    int produceNumber();

    void outputPipe(Pipe pipe);
}
