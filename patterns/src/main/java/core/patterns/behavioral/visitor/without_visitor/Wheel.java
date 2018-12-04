package core.patterns.behavioral.visitor.without_visitor;

import java.math.BigDecimal;

public class Wheel extends Part {

    public static final BigDecimal WHEEL_PRICE = new BigDecimal("10.55");

    @Override
    public BigDecimal calculateShipping() {
        return WHEEL_PRICE;
    }
}
