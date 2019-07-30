package core.data_structures;

import core.data_structures.stack.ConcurrentStack;
import core.data_structures.stack.SequentialStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Stack test")
class StackTest {

    @Nested
    @DisplayName("When sequential stack is used")
    class SequentialStackTest {

        private SequentialStack<String> stack;

        @BeforeEach
        void init() {
            stack = new SequentialStack<>();
        }

        @Test
        void shouldEnqueueElementToTheStack() {
            assertEquals(0, stack.size());
            stack.push("Test item1");
            assertEquals(1, stack.size());
        }

        @Test
        void shouldPopElementsFromTheStackInLifoOrder() {
            String testItem1 = "Test item1";
            String testItem2 = "Test item2";
            String testItem3 = "Test item3";

            stack.push(testItem1);
            stack.push(testItem2);
            stack.push(testItem3);

            assertEquals(3, stack.size());

            assertEquals(testItem3, stack.pop());
            assertEquals(testItem2, stack.pop());
            assertEquals(testItem1, stack.pop());

            assertEquals(0, stack.size());
        }

        @Test
        void shouldThrowExceptionIfPoppingFromEmptyStack() {
            assertThrows(NoSuchElementException.class, () -> stack.pop());
        }
    }

    @Nested
    @DisplayName("When concurrent stack is used")
    class ConcurrentStackTest {

        private ConcurrentStack<String> stack = new ConcurrentStack<>();

        @Test
        void shouldEnqueueElementToTheStack() {
            assertEquals(0, stack.size());
            stack.push("Test item1");
            assertEquals(1, stack.size());
        }

        @Test
        void shouldPopElementsFromTheStackInLifoOrder() {
            String testItem1 = "Test item1";
            String testItem2 = "Test item2";
            String testItem3 = "Test item3";

            stack.push(testItem1);
            stack.push(testItem2);
            stack.push(testItem3);

            assertEquals(3, stack.size());

            assertEquals(testItem3, stack.pop());
            assertEquals(testItem2, stack.pop());
            assertEquals(testItem1, stack.pop());

            assertEquals(0, stack.size());
        }
    }
}