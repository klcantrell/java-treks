package com.kalcantrell;

public class Main {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addItem(new StringListItem("Kal"));
        myLinkedList.addItem(new StringListItem("Cloud"));
        myLinkedList.addItem(new StringListItem("Beatrice"));
        myLinkedList.addItem(new StringListItem("Jenna"));
        myLinkedList.addItem(new StringListItem("Zoe"));
        myLinkedList.printList();
        myLinkedList.removeItem(new StringListItem("Cloud"));
        myLinkedList.removeItem(new StringListItem("Zoe"));
        myLinkedList.printList();
    }
}
