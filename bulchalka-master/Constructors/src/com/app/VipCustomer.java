package com.app;

public class VipCustomer {
    private String name;
    private String emailAddress;
    private double creditLimit;

    public VipCustomer() {
        this("Unknown name", "Unknown e-mail", 500);
    }

    public VipCustomer(String name, String emailAddress) {
        this(name, emailAddress, 200);
    }

    public VipCustomer(String name, String emailAddress, double creditLimit) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.creditLimit = creditLimit;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
