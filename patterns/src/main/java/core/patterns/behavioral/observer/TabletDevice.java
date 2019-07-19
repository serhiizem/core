package core.patterns.behavioral.observer;

public class TabletDevice extends Observer implements Device {

    private Observable observable;

    public TabletDevice(Observable observable) {
        this.observable = observable;
        observable.registerObserver(this);
    }

    @Override
    public void addMessage(String message) {
        observable.setState(message + " - sent from tablet");
    }

    @Override
    public void update() {
        System.out.println("Displayed on tablet: " + observable.getState());
    }
}
