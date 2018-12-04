package core.patterns.behavioral.visitor.with_visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartOrderElement implements PartElement {

    private List<PartElement> parts = new ArrayList<>();

    public void addPart(PartElement part) {
        parts.add(part);
    }

    public List<PartElement> getParts() {
        return Collections.unmodifiableList(parts);
    }

    @Override
    public void visit(Visitor visitor) {
        for (PartElement part : parts) {
            part.visit(visitor);
        }
        visitor.visit(this);
    }
}
