package core.patterns.behavioral;

import core.patterns.behavioral.memento.Caretaker;
import core.patterns.behavioral.memento.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static core.patterns.behavioral.memento.OrderStatus.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MementoTest {

    @Test
    void shouldRevertOrderToInitialState() {
        Caretaker caretaker = new Caretaker();
        Order order = new Order(15L, "Order #15");

        caretaker.save(order);
        order.setStatus(CONFIRMED);

        caretaker.revert(order);

        assertEquals(INITIAL, order.getStatus());
    }

    @Test
    @DisplayName("Calling revert sequentially a number times should revert order to the state " +
            "saved that number of times earlier")
    void doubleRevertShouldReturnOrderToStateOfTwoSavesBefore() {
        Caretaker caretaker = new Caretaker();
        Order order = new Order(15L, "Order #15");

        caretaker.save(order);
        order.setStatus(CONFIRMED);

        caretaker.save(order);
        order.setStatus(DELIVERED);

        caretaker.revert(order);
        caretaker.revert(order);

        assertEquals(INITIAL, order.getStatus());
    }

    @Test
    @DisplayName("Revert should not change the state of an order if state was not saved beforehand")
    void shouldLeaveOrderAsIsIfStateWasNotSaved() {
        Caretaker caretaker = new Caretaker();
        Order order = new Order(15L, "Order #15");

        order.setStatus(CONFIRMED);

        caretaker.revert(order);
        caretaker.revert(order);
        caretaker.revert(order);

        assertEquals(CONFIRMED, order.getStatus());
    }
}
