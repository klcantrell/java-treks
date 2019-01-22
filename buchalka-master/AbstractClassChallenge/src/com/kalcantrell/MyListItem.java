package com.kalcantrell;

public abstract class MyListItem<T> {
    private MyListItem next;
    private MyListItem previous;
    private T value;

    abstract boolean isGreaterThan(T itemValue);

    public T getValue() {
        return value;
    }

    public MyListItem getNext() {
        return next;
    }

    public MyListItem getPrevious() {
        return previous;
    }

    public void setNext(MyListItem next) {
        this.next = next;
    }

    public void setPrevious(MyListItem previous) {
        this.previous = previous;
    }
}
