package core.patterns.behavioral.visitor.without_visitor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PartOrder extends Part {

    private List<Part> parts = new ArrayList<>();

    public void addPart(Part part) {
        parts.add(part);
    }

    @Override
    public BigDecimal calculateShipping() {
        return parts.stream()
                .map(Part::calculateShipping)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
