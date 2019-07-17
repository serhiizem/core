package core.patterns.behavioral.memento;

import core.patterns.behavioral.iterator.Stack;

public class Caretaker {

    private Stack<OrderMemento> snapshots = new Stack<>();

    public void save(Order order) {
        snapshots.push(order.memento());
    }

    public void revert(Order order) {
        if (!snapshots.isEmpty()) {
            order.revert(snapshots.pop());
        }
    }
}
