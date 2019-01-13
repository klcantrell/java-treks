package com.app;

public interface CustomSubject {
    public void registerObserver(CustomObserver o);
    public void removeObserver(CustomObserver o);
    public void notifyObservers();
}
