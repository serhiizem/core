package org.core.practice.operators.conditional_operators;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings({"ConstantValue", "DataFlowIssue"})
class ConditionalOperatorsTest {

    private final boolean eyesClosed = true;
    private final boolean breathingSlowly = true;

    @Test
    void logicalAnd() {
        boolean asleep = eyesClosed & breathingSlowly;

        assertThat(asleep).isTrue();
    }

    @Test
    void logicalOr() {
        boolean resting = eyesClosed | breathingSlowly;

        assertThat(resting).isTrue();
    }

    @Test
    void logicalExclusiveOr() {
        boolean awake = eyesClosed ^ breathingSlowly;

        assertThat(awake).isFalse();
    }

    @Test
    void bothSidesEvaluation() {
        assertThrows(NullPointerException.class, () -> {

            Person person = null;
            var result = person != null & person.getAge() < 20;
        });
    }

    private static class Person {
        int age;

        public int getAge() {
            return age;
        }
    }
}