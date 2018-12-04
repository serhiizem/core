package core.patterns.behavioral.visitor.with_visitor;

import java.math.BigDecimal;

import static core.patterns.behavioral.visitor.without_visitor.Rear.REAR_PRICE;
import static core.patterns.behavioral.visitor.without_visitor.Wheel.WHEEL_PRICE;
import static core.patterns.behavioral.visitor.without_visitor.Window.WINDOW_PRICE;

public class PartShippingPriceVisitor implements Visitor {

    private BigDecimal total = BigDecimal.ZERO;

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
        System.out.println("Assembling the whole order");

    }
}
