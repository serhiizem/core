package core.patterns.behavioral.visitor.with_visitor;

public interface Visitor {
    void visit(RearElement rear);

    void visit(WheelElement wheel);

    void visit(WindowElement window);

    void visit(PartOrderElement order);
}
