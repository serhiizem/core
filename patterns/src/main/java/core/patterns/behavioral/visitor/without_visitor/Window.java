package core.patterns.behavioral.visitor.without_visitor;

import java.math.BigDecimal;

public class Window extends Part {

    public static final BigDecimal WINDOW_PRICE = new BigDecimal("5.05");

    @Override
    public BigDecimal calculateShipping() {
        return WINDOW_PRICE;
    }
}
