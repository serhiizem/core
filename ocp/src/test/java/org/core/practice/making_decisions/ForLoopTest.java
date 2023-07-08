package org.core.practice.making_decisions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    @DisplayName("Create a for loop which produces 4 3 2 1 0")
    void backwardsForLoop() {
        List<Integer> results = new ArrayList<>();

        int counter = 4;
        for (int i = counter; i >= 0; i--) {
            results.add(i);
        }

        assertThat(results).containsExactly(4, 3, 2, 1, 0);
    }
}
