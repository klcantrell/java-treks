package com.app;

public class Main {

    public static void main(String[] args) {
	    ITelephone kalsPhone = new DeskPhone(123456);
	    kalsPhone.powerOn();
	    kalsPhone.dial(123123);
	    kalsPhone.receiveCall(123456);
	    kalsPhone.answer();
    }
}
