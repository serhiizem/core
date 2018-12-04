package core.patterns.behavioral.visitor.without_visitor;

import java.math.BigDecimal;

public class Rear extends Part {

    public static final BigDecimal REAR_PRICE = new BigDecimal("15.99");

    @Override
    public BigDecimal calculateShipping() {
        return REAR_PRICE;
    }
}
