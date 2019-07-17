package core.patterns.behavioral.memento;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import static core.patterns.behavioral.memento.OrderStatus.INITIAL;

@Getter
@RequiredArgsConstructor
public class Order {

    private final Long id;
    private final String name;

    @Setter private OrderStatus status = INITIAL;

    public void revert(OrderMemento memento) {
        this.status = memento.getStatus();
    }

    public OrderMemento memento() {
        return new OrderMemento(this.status);
    }
}
