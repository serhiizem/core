package org.core.practice.operators.conditional_operators;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class ShortCircuitBehaviorTest {

    @Test
    void noPreDecrement() {
        int age = 25;

        if (age >= 25 || --age <= 24) {
            // do nothing
        }

        assertThat(age).isEqualTo(25);
    }
}
