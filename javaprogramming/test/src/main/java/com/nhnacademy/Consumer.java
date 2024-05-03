package com.nhnacademy;

public interface Consumer {
    void receiveMessage(String message);
    void receiveNumber(int number);

    void inputPipe(Pipe pipe);
}
