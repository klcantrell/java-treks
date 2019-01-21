package com.app;

public interface ITelephone {
    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean receiveCall(int phoneNumber);
    boolean isRinging();
}
