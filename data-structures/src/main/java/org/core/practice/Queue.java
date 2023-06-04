package org.core.practice;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        Node<T> next;
        T item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(T item) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
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
        return new QueueIterator(first);
    }

    @AllArgsConstructor
    private class QueueIterator implements Iterator<T> {

        private Node<T> current;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Queue has no items");
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
