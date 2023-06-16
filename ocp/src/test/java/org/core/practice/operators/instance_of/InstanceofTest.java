package org.core.practice.operators.instance_of;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ConstantValue")
class InstanceofTest {

    @Test
    void nullAndInstanceof() {
        var result = null instanceof Object;

        assertThat(result).isFalse();
    }

    @Test
    void nullObjectAndInstanceof() {
        Object value = null;

        var result = value instanceof Object;

        assertThat(result).isFalse();
    }
}