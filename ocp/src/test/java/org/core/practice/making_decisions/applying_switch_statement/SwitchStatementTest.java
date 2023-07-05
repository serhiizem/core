package org.core.practice.making_decisions.applying_switch_statement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@SuppressWarnings({"SameParameterValue", "StatementWithEmptyBody", "DataFlowIssue", "EnhancedSwitchMigration"})
class SwitchStatementTest {

    @Test
    void shouldCompileSuccessfullyWithNoCases() {
        assertThatCode(() -> {

            int month = 3;
            switch (month) {
            }

        }).doesNotThrowAnyException();
    }

    /**
     * Final variable value, initialized with literal, is known at compile
     * time hence permitted for usage in switch case
     */
    @Test
    void shouldPermitFinalVariablesOfSameDataTypeToBeUsedInSwitchCase() {
        int result = 0;

        int inputValue = 5;
        final int initializedFinalVariable = 5;
        switch (inputValue) {
            case initializedFinalVariable: {result = 5; break;}
            case 3 * 5: {result = 10; break;}
        }

        assertThat(result).isEqualTo(5);
    }

    @Test
    void shouldIterateThroughAllTheCasesWhenMissingBreak() {
        assertThat(getSeason(22)).isEqualTo("Fall");
    }

    private static String getSeason(int month) {
        String season;
        switch (month) {
            case 12, 1, 2:
                season = "Winter";
            case 3, 4, 5:
                season = "Spring";
            default:
                season = "Unknown";
            case 6, 7, 8:
                season = "Summer";
            case 9, 10, 11:
                season = "Fall";
        }
        return season;
    }
}