package org.core.practice;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {

    private Node<T> first;
    private int size;

    private static class Node<T> {
        Node<T> next;
        T item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
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
            return null;
        }
        T item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return first.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator(first);
    }

    @AllArgsConstructor
    private class StackIterator implements Iterator<T> {

        private Node<T> current;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Stack has no items");
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
