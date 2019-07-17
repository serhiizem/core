package core.patterns.behavioral.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {

    private Stack<String> stack = new Stack<>();

    private static final List<String> TEST_ITEMS = new ArrayList<>();

    static {
        TEST_ITEMS.add("Jim");
        TEST_ITEMS.add("Craig");
        TEST_ITEMS.add("Corey");
        TEST_ITEMS.add("Mick");
    }

    @BeforeEach
    void init() {
        stack.clear();
        TEST_ITEMS.forEach(item -> stack.push(item));
    }

    @Test
    void shouldReturnCollectionElementsUsingPop() {
        List<String> expectedItems = new ArrayList<>(TEST_ITEMS);
        reverse(expectedItems);

        List<String> result = new ArrayList<>();

        result.add(stack.pop());
        result.add(stack.pop());
        result.add(stack.pop());
        result.add(stack.pop());

        assertEquals(expectedItems, result);
    }

    @Test
    void shouldIterateOverStackTraversingEntireCollection() {
        List<String> expectedItems = new ArrayList<>(TEST_ITEMS);
        reverse(expectedItems);

        List<String> result = new ArrayList<>();

        for (String stackItem : stack) {
            result.add(stackItem);
        }

        assertEquals(expectedItems, result);
    }

    @Test
    void shouldThrowExceptionWhenTryingToPopFromEmptyStack() {
        assertThrows(IllegalStateException.class, () -> {
            List<String> expectedItems = new ArrayList<>(TEST_ITEMS);
            reverse(expectedItems);

            for (String stackItem : stack) {
                stack.pop();
            }

            stack.pop();
        });
    }
}