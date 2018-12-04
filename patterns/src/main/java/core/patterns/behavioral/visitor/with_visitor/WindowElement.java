package core.patterns.behavioral.visitor.with_visitor;

public class WindowElement implements PartElement {

    @Override
    public void visit(Visitor visitor) {
        visitor.visit(this);
    }
}
