package org.core.practice.operators.numeric_promotion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumericPromotionTest {

    @Test
    void promotionToLargerDataType() {
        int x = 1;
        long y = 33;

        var result = x * y;

        assertThat(result).isInstanceOf(Long.class);
    }

    @Test
    void promotionToIntegerWhenUsedWithBinaryOperator() {
        short x = 10;
        short y = 3;

        var result = x * y;

        assertThat(result).isInstanceOf(Integer.class);
    }

    @Test
    void promotionRulesCombination() {
        short w = 14;
        float x = 13;

        double y = 30;

        var result = w * x / y;

        assertThat(result).isInstanceOf(Double.class);
    }
}