package core.data_structures.stack;

import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentStack<T> implements Stack<T> {

    private AtomicReference<StackNode<T>> head = new AtomicReference<>();

    @Override
    public void push(T item) {
        StackNode<T> newHead = new StackNode<>(item);
        StackNode<T> currentHead;
        do {
            currentHead = head.get();
            newHead.next = currentHead;
        } while (!head.compareAndSet(currentHead, newHead));
    }

    @Override
    public T pop() {
        StackNode<T> currentHead;
        do {
            currentHead = head.get();
        } while (!head.compareAndSet(currentHead, currentHead.next));

        return currentHead.item;
    }

    public int size() {
        int size = 0;
        for (StackNode<T> node = head.get(); node != null; node = node.next) {
            size++;
        }
        return size;
    }

    private static class StackNode<T> {
        private T item;
        private StackNode<T> next;

        StackNode(T item) {
            this.item = item;
        }
    }
}
