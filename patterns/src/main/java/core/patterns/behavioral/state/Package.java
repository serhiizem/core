package core.patterns.behavioral.state;

public class Package {

    private PackageState state;

    private PackageState processingState;
    private PackageState deliveringState;
    private PackageState deliveredState;

    public Package() {
        this.state = new CreatedState(this);

        this.processingState = new ProcessingState(this);
        this.deliveringState = new DeliveringState(this);
        this.deliveredState = new DeliveredState(this);
    }

    public void process() {
        state.processPackage();
    }

    void setState(PackageState state) {
        this.state = state;
    }

    public PackageState getState() {
        return state;
    }

    PackageState getProcessingState() {
        return processingState;
    }

    PackageState getDeliveringState() {
        return deliveringState;
    }

    PackageState getDeliveredState() {
        return deliveredState;
    }
}
