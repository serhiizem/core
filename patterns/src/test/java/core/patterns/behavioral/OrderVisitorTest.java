package core.patterns.behavioral;

import core.patterns.behavioral.visitor.with_visitor.*;
import core.patterns.behavioral.visitor.without_visitor.PartOrder;
import core.patterns.behavioral.visitor.without_visitor.Rear;
import core.patterns.behavioral.visitor.without_visitor.Wheel;
import core.patterns.behavioral.visitor.without_visitor.Window;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static core.patterns.behavioral.visitor.without_visitor.Rear.REAR_PRICE;
import static core.patterns.behavioral.visitor.without_visitor.Wheel.WHEEL_PRICE;
import static core.patterns.behavioral.visitor.without_visitor.Window.WINDOW_PRICE;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Visitor test")
public class OrderVisitorTest {

    private static final BigDecimal ORDER_PLAIN_TOTAL =
            REAR_PRICE.add(WHEEL_PRICE).add(WINDOW_PRICE);

    @Nested
    @DisplayName("When visitor is not used")
    class WithoutVisitor {

        @Test
        @DisplayName("No discount was added irrespective of the number of items in order")
        public void shouldDisplayTotalPriceAsPlainSum() {
            PartOrder partOrder = new PartOrder();
            partOrder.addPart(new Rear());
            partOrder.addPart(new Wheel());
            partOrder.addPart(new Window());

            BigDecimal shippingOrderPrice = partOrder.calculateShipping();

            assertTrue(shippingOrderPrice.equals(ORDER_PLAIN_TOTAL));
        }
    }

    @Nested
    @DisplayName("When visitor is used")
    class UsingVisitor {

        @Test
        @DisplayName("If there are more than two items in order total price should be lesser")
        public void shouldApplyDiscountIfEligible() {
            PartOrderElement orderElement = new PartOrderElement();
            orderElement.addPart(new RearElement());
            orderElement.addPart(new WheelElement());
            orderElement.addPart(new WindowElement());

            PartShippingPriceVisitor orderVisitor = new PartShippingPriceVisitor();
            orderElement.visit(orderVisitor);

            BigDecimal visitorTotalPrice = orderVisitor.getTotalPrice();

            assertTrue(visitorTotalPrice.compareTo(ORDER_PLAIN_TOTAL) < 1);
        }
    }
}
