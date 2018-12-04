package core.patterns.behavioral;

import core.patterns.behavioral.visitor.with_visitor.*;
import core.patterns.behavioral.visitor.without_visitor.Rear;
import core.patterns.behavioral.visitor.without_visitor.Wheel;
import core.patterns.behavioral.visitor.without_visitor.Window;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Visitor test")
public class VisitorTest {

    @DisplayName("When visitor is not used")
    class WithoutVisitor {


    }

    @DisplayName("When visitor is used")
    class UsingVisitor {

        @Test
        @DisplayName("")
        public void should() {
            RearElement rear = new RearElement();
            WheelElement wheel = new WheelElement();
            WindowElement window = new WindowElement();
            PartOrderElement orderElement = new PartOrderElement();

            PartShippingPriceVisitor shippingPriceVisitor = new PartShippingPriceVisitor();
            shippingPriceVisitor.visit(rear);
            shippingPriceVisitor.visit(wheel);
            shippingPriceVisitor.visit(window);
            shippingPriceVisitor.visit(orderElement);
        }
    }
}
