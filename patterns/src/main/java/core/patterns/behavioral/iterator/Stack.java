package core.patterns.behavioral.iterator;

import java.util.Iterator;

public class Stack<E> implements Iterable<E> {

    private Node<E> top;
    private int size;

    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void
    push(E item) {
        Node<E> oldTop = top;
        top = new Node<>();
        top.item = item;
        top.next = oldTop;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E item = top.item;
        top = top.next;
        size--;
        return item;
    }

    public void clear() {
        top = null;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator(top);
    }

    private class StackIterator implements Iterator<E> {

        private Node<E> current;

        public StackIterator(Node<E> top) {
            this.current = top;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IllegalStateException("Stack is empty");
            }
            E item = current.item;
            current = current.next;

            return item;
        }
    }
}


















