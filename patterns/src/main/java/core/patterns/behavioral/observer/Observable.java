package core.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    private List<Observer> observers = new ArrayList<>();

    public abstract void setState(String message);

    public abstract String getState();

    void registerObserver(Observer observer) {
        observers.add(observer);
    }

    void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
