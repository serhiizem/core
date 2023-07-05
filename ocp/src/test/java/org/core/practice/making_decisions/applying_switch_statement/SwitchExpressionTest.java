package org.core.practice.making_decisions.applying_switch_statement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"DataFlowIssue", "SameParameterValue"})
public class SwitchExpressionTest {

    @Test
    void shouldUseSwitchExpressionToDetermineSeason() {
        int month = 4;

        assertThat(getSeason(month)).isEqualTo("Spring");
    }

    /**
     * Semicolon after the expression is required if switch returns a value
     * or used with assignment operator.
     * Default clause is required if all the possible cases are not covered.
     */
    private String getSeason(int month) {
        return switch(month) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Fall";
            default -> "Unknown";
        };
    }

    @Test
    void shouldYieldValueFromCaseBlock() {
        int fish = 1;

        var name = switch(fish) {
            case 1 -> "Goldfish";
            case 2 -> {yield "Trout";}
            default -> "Unknown";
        };

        assertThat(name).isEqualTo("Goldfish");
    }

    @Test
    void shouldNotRequireDefaultClauseIfAllPossibleValuesAreCovered() {
        String weather = getWeather(Season.SUMMER);

        assertThat(weather).isEqualTo("Hot");
    }

    enum Season {WINTER, SPRING, SUMMER, FALL}
    
    private String getWeather(Season value) {
        return switch(value) {
            case WINTER -> "Cold";
            case SPRING -> "Rainy";
            case SUMMER -> "Hot";
            case FALL -> "Warm";
        };
    }
}
