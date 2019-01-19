package com.app;

import java.util.Scanner;

public class MobilePhone {
    private static Scanner scanner = new Scanner(System.in);
    Contacts contacts;

    public MobilePhone(Contacts contacts) {
        this.contacts = contacts;
    }

    public void run() {
        boolean quit = false;
        printInstructions();
        while (!quit) {
            System.out.println("\nEnter your choice: (6 to show choices)");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    printInstructions();
                    break;
                case 2:
                    showContacts();
                    break;
                case 3:
                    addContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    removeContact();
                    break;
                case 0:
                    quit = true;
                    quit();
                    break;
                default:
                    System.out.println("Not a valid choice, try again");
                    break;
            }
        }
    }

    public void printInstructions() {
        System.out.println("\nPress");
        System.out.println("\t1 - To print list of menu options");
        System.out.println("\t2 - To print list of contacts");
        System.out.println("\t3 - To add a contact");
        System.out.println("\t4 - To update a contact");
        System.out.println("\t5 - To delete a contact");
        System.out.println("\t0 - To close your phone");
    }

    public void showContacts() {
        contacts.showContacts();
    }

    public void addContact() {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the number: ");
        String number = scanner.nextLine();
        contacts.addContact(name, number);
    }

    public void updateContact() {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        if (contacts.hasContact(name)) {
            System.out.println("Enter the number: ");
            String number = scanner.nextLine();
            contacts.updateContact(name, number);
        } else {
            System.out.println("Could not find that contact");
        }
    }

    public void removeContact() {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        if (contacts.hasContact(name)) {
            contacts.deleteContact(name);
        } else {
            System.out.println("Could not find that contact");
        }
    }

    public void quit() {
        System.out.println("Closing phone");
    }
}
