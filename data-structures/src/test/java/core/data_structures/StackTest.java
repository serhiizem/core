package core.data_structures;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.NoSuchElementException;

public class StackTest {

    private Stack<String> stack;

    @Before
    public void init() {
        stack = new Stack<>();
    }

    @Test
    public void shouldEnqueueElementToTheStack() {
        Assertions.assertEquals(0, stack.getSize());
        stack.push("Test item1");
        Assertions.assertEquals(1, stack.getSize());
    }

    @Test
    public void shouldPopElementsFromTheStackInLifoOrder() {
        String testItem1 = "Test item1";
        String testItem2 = "Test item2";
        String testItem3 = "Test item3";

        stack.push(testItem1);
        stack.push(testItem2);
        stack.push(testItem3);

        Assertions.assertEquals(3, stack.getSize());

        Assertions.assertEquals(testItem3, stack.pop());
        Assertions.assertEquals(testItem2, stack.pop());
        Assertions.assertEquals(testItem1, stack.pop());

        Assertions.assertEquals(0, stack.getSize());
    }

    @Test
    public void shouldThrowExceptionIfPoppingFromEmptyStack() {
        Assertions.assertThrows(NoSuchElementException.class, () -> stack.pop());
    }
}