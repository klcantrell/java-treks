package com.app;

public class Main {

    public static void main(String[] args) {
//        Bank myAccount = new Bank("12345", 0, "kal@cantrell.com", "Kal", "808-349-1117");
//        Bank myAccount = new Bank();
        VipCustomer me = new VipCustomer("Kal", "kal@sup.com");
        Bank myAccount = new Bank(me.getEmailAddress(), me.getName(), "808-313-1313");
        myAccount.deposit(100.25);
        myAccount.withraw(100);
        myAccount.withraw(2);
    }
}
