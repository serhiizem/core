package core.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("WeakerAccess")
public class Queue<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<E> {
        private E item;
        public Node<E> next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(T item) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator(first);
    }

    private class QueueIterator implements Iterator<T> {

        private Node<T> first;

        public QueueIterator(Node<T> first) {
            this.first = first;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T item = first.item;
                first = first.next;
                return item;
            } else {
                throw new NoSuchElementException("There are no more element in queue");
            }
        }

        @Override
        public boolean hasNext() {
            return first != null;
        }
    }
}
