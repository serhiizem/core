package core.patterns.behavioral.state;

public class DeliveringState extends PackageState {

    public DeliveringState(Package pckg) {
        super(pckg);
    }

    @Override
    public void processPackage() {
        pckg.setState(pckg.getDeliveredState());
    }
}
