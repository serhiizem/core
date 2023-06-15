package org.core.practice.operators.compound_assignment;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompoundAssignmentTest {

    @Test
    void implicitCastByAssigmentOperator() {
        int step = 5;
        long multiplicand = 4L;

        step *= multiplicand;

        assertThat(step).isInstanceOf(Integer.class);
    }

    // step = step * multiplicand; // DOES NOT COMPILE
}