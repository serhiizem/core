package org.core.practice.core_apis;

import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class StringFormattingTest {

    @Test
    void name() {
        var pi = 3.14159265359;

        assertThat(format("[%f]", pi))
                .isEqualTo("[3.141593]");

        assertThat(format("[%12.8f]", pi))
                .isEqualTo("[  3.14159265]");

        assertThat(format("[%012f]", pi))
                .isEqualTo("[00003.141593]");

        assertThat(format("[%12.2f]", pi))
                .isEqualTo("[        3.14]");

        assertThat(format("[%.3f]", pi))
                .isEqualTo("[3.142]");

    }
}
