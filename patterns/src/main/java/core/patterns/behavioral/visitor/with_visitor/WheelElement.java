package core.patterns.behavioral.visitor.with_visitor;

public class WheelElement extends PartElement {

    @Override
    void visit(Visitor visitor) {
        visitor.visit(this);
    }
}
