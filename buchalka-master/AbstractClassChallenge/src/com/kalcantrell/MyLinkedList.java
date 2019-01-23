package com.kalcantrell;

public class MyLinkedList {
    private MyListItem head;

    public MyLinkedList() {
        this.head = null;
    }

    public void addItem(MyListItem listItem) {
        MyListItem current = this.head;

        if (current == null) {
            this.head = listItem;
            this.head.setNext(null);
            this.head.setPrevious(null);
            return;
        }

        while (listItem.isGreaterThan(current.getValue())) {
            if (current.getNext() == null) {
                current.setNext(listItem);
                current.getNext().setNext(null);
                current.getNext().setPrevious(current);
                return;
            }
            current = current.getNext();
        }

        if (current == this.head) {
            MyListItem temp = this.head;
            this.head = listItem;
            this.head.setPrevious(null);
            this.head.setNext(temp);
            this.head.getNext().setPrevious(this.head);
            return;
        } else {
            MyListItem previous = current.getPrevious();
            MyListItem temp = current;
            previous.setNext(listItem);
            previous.getNext().setNext(temp);
            temp.setPrevious(previous.getNext());
        }
    }

    public void removeItem(MyListItem listItem) {
        MyListItem current = this.head;

        if (current == null) {
            System.out.println("No items in this list");
            return;
        }

        if (current.getValue().equals(listItem.getValue())) {
            MyListItem temp = this.head;
            this.head = listItem;
            listItem.setNext(temp.getNext());
            listItem.setPrevious(null);
            return;
        }

        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(listItem.getValue())) {
                if (current.getNext().getNext() == null) {
                    current.setNext(null);
                    return;
                } else {
                    current.setNext(current.getNext().getNext());
                    current.getNext().setPrevious(current);
                    return;
                }
            }
            current = current.getNext();
        }

        System.out.println("Could not find that item in this list");
    }

    public void printList() {
        int itemNumber = 1;
        MyListItem current = this.head;
        if (current == null) {
            System.out.println("There are no items in this list");
            return;
        }
        System.out.println("Item " + itemNumber + ": " + current.getValue());
        itemNumber++;
        while (current.getNext() != null) {
            current = current.getNext();
            System.out.println("Item " + itemNumber + ": " + current.getValue());
            itemNumber++;
        }
    }
}
