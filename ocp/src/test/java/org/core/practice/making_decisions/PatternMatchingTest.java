package org.core.practice.making_decisions;

import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SuppressWarnings({"StatementWithEmptyBody"})
class PatternMatchingTest {

    @Test
    void shouldImplicitlyCastTypeThenUsingPatternMatching() {
        Integer number = 5;

        verifyNumber(number);
    }

    private void verifyNumber(Number number) {
        if (number instanceof Integer value) {
            int comparisonResult = value.compareTo(5);
            assertThat(comparisonResult).isEqualTo(0);
        } else fail(format("Did not receive expected comparison result for %s", number));
    }

    @Test
    void shouldCombineLogicalStatementsWithPatternMatching() {
        Long number = 1L;

        verifyNumberWithLogic(number);
    }

    private void verifyNumberWithLogic(Number number) {
        if (number instanceof Long value && value.compareTo(2L) < 0) {
            // body is not needed, because evaluation is done inside if statement
        } else fail(format("Did not receive expected comparison result for %s", number));
    }
}