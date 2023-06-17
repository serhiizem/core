package org.core.practice.operators.conditional_operators;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@SuppressWarnings("ConstantValue")
public class TernaryOperatorTest {

    @Test
    void noNestedTernaryOperatorEvaluation() {
        int owl = 5;
        int food = owl < 4 ? owl > 2 ? 3 : 4 : 5;

        assertThat(food).isEqualTo(5);
    }

    @Test
    void nestedTernaryOperatorEvaluation() {
        int owl = 5;
        int food = owl > 4 ? owl > 2 ? 3 : 4 : 5;

        assertThat(food).isEqualTo(3);
    }

    @Test
    void ternaryOperatorResultExpressionsCanHaveDifferentDataTypes() {
        int stripes = 7;

        assertThatNoException().isThrownBy(() -> {
            var serializable = stripes > 5 ? 21 : "Zebra";
        });
    }

    @Test
    void ternaryOperatorUnperformedSideEffectsOfRightExpression() {
        int sheep = 1;
        int wolves = 1;

        var result = sheep <= 10 ? sheep++ : wolves++;

        assertThat(sheep).isEqualTo(2);
        assertThat(wolves).isEqualTo(1);
    }

    @Test
    void ternaryOperatorUnperformedSideEffectsOfLeftExpression() {
        int sheep = 1;
        int wolves = 1;

        var result = sheep >= 10 ? sheep++ : wolves++;

        assertThat(sheep).isEqualTo(1);
        assertThat(wolves).isEqualTo(2);
    }
}
