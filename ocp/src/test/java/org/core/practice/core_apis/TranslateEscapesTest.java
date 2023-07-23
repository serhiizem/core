package org.core.practice.core_apis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TranslateEscapesTest {

    @Test
    void translateEscapes() {
        assertThat("a\\tb".translateEscapes())
                .isEqualTo("a\tb");
    }
}
