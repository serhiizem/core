package core.data_structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class StackTest {

    private Stack<String> stack;

    @BeforeEach
    public void init() {
        stack = new Stack<>();
    }

    @Test
    public void shouldEnqueueElementToTheStack() {
        Assertions.assertEquals(0, stack.size());
        stack.push("Test item1");
        Assertions.assertEquals(1, stack.size());
    }

    @Test
    public void shouldPopElementsFromTheStackInLifoOrder() {
        String testItem1 = "Test item1";
        String testItem2 = "Test item2";
        String testItem3 = "Test item3";

        stack.push(testItem1);
        stack.push(testItem2);
        stack.push(testItem3);

        Assertions.assertEquals(3, stack.size());

        Assertions.assertEquals(testItem3, stack.pop());
        Assertions.assertEquals(testItem2, stack.pop());
        Assertions.assertEquals(testItem1, stack.pop());

        Assertions.assertEquals(0, stack.size());
    }

    @Test
    public void shouldThrowExceptionIfPoppingFromEmptyStack() {
        Assertions.assertThrows(NoSuchElementException.class, () -> stack.pop());
    }
}