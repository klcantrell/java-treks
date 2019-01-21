package com.app;

public class Main {

    public static void main(String[] args) {
	    ITelephone kalsPhone = new DeskPhone(123456);
	    kalsPhone.powerOn();
	    kalsPhone.dial(123123);
	    kalsPhone.receiveCall(123456);
	    kalsPhone.answer();

	    ITelephone kalsMobile = new MobilePhone(808123);
	    kalsMobile.answer();
	    kalsMobile.dial(123123);
	    kalsMobile.powerOn();
	    kalsMobile.receiveCall(808123);
	    kalsMobile.answer();
    }
}
