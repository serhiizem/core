package org.core.practice.operators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComplementAndNegationTest {

    @Test
    void complementOperatorTest() {
        int value = 3;

        int complement = ~value;

        assertThat(complement).isEqualTo(-4);
    }

    @Test
    @DisplayName("Negation operator reverses the sign of a numeric expression")
    void negationOperatorTest() {
        double temperature = 10.2;

        temperature = -temperature;

        assertThat(temperature).isEqualTo(-10.2);
    }
}