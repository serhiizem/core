package core.data_structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QueueTest {

    private Queue<String> queue;

    @BeforeEach
    void init() {
        queue = new Queue<>();
    }

    @Test
    void shouldAddItemsToTheQueue() {
        assertEquals(0, queue.size());
        queue.enqueue("Test item1");
        queue.enqueue("Test item2");
        assertEquals(2, queue.size());
    }

    @Test
    void shouldDequeueInsertedElement() {
        String queuedElement = "Test item1";
        queue.enqueue(queuedElement);
        String dequeuedElement = queue.dequeue();
        assertEquals(queuedElement, dequeuedElement);
    }

    @Test
    void shouldDequeueInFifoOrder() {
        String testItem1 = "Test item1";
        String testItem2 = "Test item2";
        String testItem3 = "Test item3";

        queue.enqueue(testItem1);
        queue.enqueue(testItem2);
        queue.enqueue(testItem3);

        assertEquals(testItem1, queue.dequeue());
        assertEquals(testItem2, queue.dequeue());
        assertEquals(testItem3, queue.dequeue());
    }

    @Test
    void shouldThrowIllegalStateExceptionIfQueueIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }
}