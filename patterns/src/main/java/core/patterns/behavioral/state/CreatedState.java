package core.patterns.behavioral.state;

public class CreatedState extends PackageState {

    public CreatedState(Package pckg) {
        super(pckg);
    }

    @Override
    public void processPackage() {
        pckg.setState(pckg.getProcessingState());
    }
}
