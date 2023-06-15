package org.core.practice.operators.return_assignment_result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"AssignmentUsedAsCondition", "ConstantValue"})
class ReturnAssignmentResultTest {

    @Test
    void valueOfAssignmentReturned() {
        int wolf = 5;
        long coyote = (wolf = 3);

        assertThat(wolf).isEqualTo(3);
        assertThat(coyote).isEqualTo(3);
    }

    @Test
    void assignmentResultUsageInLogicalFlow() {
        boolean healthy = false;

        if (healthy = true) {
            assertThat(healthy).isTrue();
        }
    }
}