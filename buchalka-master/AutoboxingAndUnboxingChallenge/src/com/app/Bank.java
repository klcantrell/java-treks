package com.app;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches;

    public Bank() {
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name) {
        if (findBranch(name) == null) {
            Branch newBranch = new Branch(name);
            branches.add(newBranch);
            System.out.println("New branch added: " + name);
            return true;
        }
        System.out.println(name + " branch already exists");
        return false;
    }


    public void addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            boolean successfullyAdded = branch.addCustomer(customerName, initialTransaction);
            if (successfullyAdded) {
                System.out.println(customerName + " added to " + branch.getName() + " branch");
            } else {
                System.out.println(customerName + " already exists");
            }
        } else {
            System.out.println(branchName + " branch does not exist");
        }
    }

    public void addCustomer(String branchName, String customerName) {
        addCustomer(branchName, customerName, 0.00);
    }

    public void addTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            boolean successfullyAdded = branch.addTransaction(customerName, transaction);
            if (successfullyAdded) {
                System.out.println(customerName + " from " + branchName + " branch transacted " + transaction);
            } else {
                System.out.println(customerName + " does not exist at " + branchName);
            }
        } else {
            System.out.println("That branch does not exist");
        }
    }

    public void showCustomers() {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            System.out.println("\n" + branch.getName() + " Branch");
            branch.showCustomers();
            System.out.println("");
        }
    }

    private Branch findBranch(String name) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(name))
                return branches.get(i);
        }
        return null;
    }

}
