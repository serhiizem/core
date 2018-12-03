package core.patterns.behavioral.visitor.with_visitor;

public class WindowElement extends PartElement {

    @Override
    void visit(Visitor visitor) {
        visitor.visit(this);
    }
}
