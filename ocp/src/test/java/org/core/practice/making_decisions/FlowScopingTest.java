package org.core.practice.making_decisions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"ConstantValue", "SameParameterValue"})
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

    @Test
    @DisplayName("Pattern matching variable should be available where " +
            "compiler can identify its type")
    void shouldScopePatternMatchingVariable() {
        assertThat(getFishName("Fluffy"))
                .isEqualTo("FluffyFluffy");
    }

    private String getFishName(Object fish) {
        if (!(fish instanceof String guppy))
            return "Eat!";
        else if (!(fish instanceof String exc)) {
            throw new RuntimeException();
        } else {
            return guppy + exc;
        }
    }
}
