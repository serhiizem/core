package org.core.practice.making_decisions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FlowScopingTest {

    @Test
    void shouldDetermineTypeAfterReturnBasedOnInstanceOfOperator() {
        Integer number = 10;

        verifyNumber(number);
    }

    private void verifyNumber(Number number) {
        if (!(number instanceof Integer data))
            return;
        int comparisonResult = data.compareTo(5);

        assertThat(comparisonResult).isEqualTo(1);
    }
}
