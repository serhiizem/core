package core.patterns.behavioral.memento;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderMemento {
    private final OrderStatus status;
}
