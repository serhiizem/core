package core.data_structures;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTest {

    private Queue<String> queue;

    @Before
    public void init() {
        queue = new Queue<>();
    }

    @Test
    public void shouldAddItemsToTheQueue() {
        assertEquals(0, queue.size());
        queue.enqueue("Test item1");
        queue.enqueue("Test item2");
        assertEquals(2, queue.size());
    }

    @Test
    public void shouldDequeueInsertedElement() {
        String queuedElement = "Test item1";
        queue.enqueue(queuedElement);
        String dequeuedElement = queue.dequeue();
        Assertions.assertEquals(queuedElement, dequeuedElement);
    }

    @Test
    public void shouldDequeueInFifoOrder() {
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
    public void shouldThrowIllegalStateExceptionIfQueueIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }
}