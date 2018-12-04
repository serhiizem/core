package core.patterns.behavioral.visitor.with_visitor;

import java.math.BigDecimal;

import static core.patterns.behavioral.visitor.without_visitor.Rear.REAR_PRICE;
import static core.patterns.behavioral.visitor.without_visitor.Wheel.WHEEL_PRICE;
import static core.patterns.behavioral.visitor.without_visitor.Window.WINDOW_PRICE;

public class PartShippingPriceVisitor implements Visitor {

    private static final BigDecimal DISCOUNT = new BigDecimal("3.00");

    private BigDecimal total = BigDecimal.ZERO;

    public BigDecimal getTotalPrice() {
        return total;
    }

    @Override
    public void visit(RearElement rear) {
        System.out.println("Adding rear to order");
        total = total.add(REAR_PRICE);
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Adding wheel to order");
        total = total.add(WHEEL_PRICE);
    }

    @Override
    public void visit(WindowElement window) {
        System.out.println("Adding window to order");
        total = total.add(WINDOW_PRICE);
    }

    @Override
    public void visit(PartOrderElement order) {
        if (order.getParts().size() >= 3) {
            System.out.println("There are more than three items in order. Applying discount");
            total = total.subtract(DISCOUNT);
        }
        System.out.println("Total price is: " + total.toString());
    }
}
