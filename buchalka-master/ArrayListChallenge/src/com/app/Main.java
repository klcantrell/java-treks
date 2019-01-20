package com.app;

public class Main {

    public static void main(String[] args) {
        Contacts contacts = new Contacts();
	    MobilePhone mobilePhone = new MobilePhone(contacts);
	    mobilePhone.run();
    }
}
