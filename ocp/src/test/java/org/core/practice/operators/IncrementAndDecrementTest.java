package org.core.practice.operators;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IncrementAndDecrementTest {

    @Test
    void testPreAndPostIncrement() {
        int attendance = 5;

        assertThat(attendance).isEqualTo(5);
        assertThat(++attendance).isEqualTo(6);

        assertThat(attendance).isEqualTo(6);
        assertThat(attendance--).isEqualTo(6);
    }
}
