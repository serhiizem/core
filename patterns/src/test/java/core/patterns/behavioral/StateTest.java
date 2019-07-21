package core.patterns.behavioral;

import core.patterns.behavioral.state.*;
import core.patterns.behavioral.state.Package;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

class StateTest {

    private Package pckg;

    @BeforeEach
    void init() {
        pckg = new Package();
    }

    @Test
    void shouldCreatePackageInCreatedState() {
        PackageState state = pckg.getState();

        assertThat(state, instanceOf(CreatedState.class));
    }

    @Test
    void shouldTransitionFromCreatedToProcessing() {
        pckg.process();

        PackageState state = pckg.getState();

        assertThat(state, instanceOf(ProcessingState.class));
    }

    @Test
    void shouldTransitionFromProcessingToDelivering() {
        pckg.process();
        pckg.process();

        PackageState state = pckg.getState();

        assertThat(state, instanceOf(DeliveringState.class));
    }

    @Test
    void shouldTransitionFromDeliveringToDelivered() {
        pckg.process();
        pckg.process();
        pckg.process();

        PackageState state = pckg.getState();

        assertThat(state, instanceOf(DeliveredState.class));
    }
}