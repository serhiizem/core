package org.core.practice.making_decisions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("StatementWithEmptyBody")
public class ForLoopTest {

    @Test
    @DisplayName("Initialization block of a for loop can contain " +
            "variable declared before the loop itself")
    void initializationBlockVariableTest() {
        int i;

        for (i = 0; i < 5; i++) {
        }

        assertThat(i).isEqualTo(5);
    }
}
