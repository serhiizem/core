package core.data_structures;

import java.util.NoSuchElementException;

@SuppressWarnings("WeakerAccess")
public class Stack<T> {

    private Node<T> first;
    private int size;

    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    public void push(T item) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
