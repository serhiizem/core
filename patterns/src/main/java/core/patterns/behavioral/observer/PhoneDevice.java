package core.patterns.behavioral.observer;

public class PhoneDevice extends Observer implements Device {

    public PhoneDevice(Observable observable) {
        this.observable = observable;
        observable.registerObserver(this);
    }

    @Override
    public void addMessage(String message) {
        observable.setState(message + " - sent from phone");
    }

    @Override
    public void update() {
        System.out.println("Displayed on phone: " + observable.getState());
    }
}
