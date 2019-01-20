package com.app;

import java.util.ArrayList;

public class Contacts {
    private ArrayList<Contact> contacts;

    public Contacts() {
        contacts = new ArrayList<>();
    }

    public void showContacts() {
        if (contacts.size() > 0) {
            for (int i = 0; i < contacts.size(); i++) {
                Contact currentContact = contacts.get(i);
                System.out.println(currentContact.getName() + " | " + currentContact.getNumber());
            }

        } else {
            System.out.println("You have no contacts");
        }
    }

    public void addContact(String name, String number) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                System.out.println("That contact exists already!");
                return;
            }
        }
        Contact newContact = new Contact(name, number);
        contacts.add(newContact);
        System.out.println("Contact added");
    }

    public void updateContact(String name, String number) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equals(name)) {
                contact.setNumber(number);
                System.out.println("Contact updated");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public void deleteContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equals(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public boolean hasContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equals(name))
                return true;
        }
        return false;
    }
}
