package com.app;

public class ExtendedPassword extends Password {
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

    // faking an insecure saving of the password
//    public void storePassword() { // can't override a final method in the base class
//        System.out.println("Saving password as " + this.decryptedPassword);
//    }
}
