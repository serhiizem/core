package core.patterns.behavioral.state;

public class ProcessingState extends PackageState {

    public ProcessingState(Package pckg) {
        super(pckg);
    }

    @Override
    public void processPackage() {
        pckg.setState(pckg.getDeliveringState());
    }
}
