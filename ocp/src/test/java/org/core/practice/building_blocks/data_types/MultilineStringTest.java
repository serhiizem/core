package org.core.practice.building_blocks.data_types;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("UnnecessaryStringEscape")
class MultilineStringTest {

    @Test
    void closingQuotesOnANewline() {
        String pyramid = """
                  *
                 * *
                * * *
                """;

        assertThat(pyramid.lines().count()).isEqualTo(3L);
    }

    @Test
    void programmaticNewlineRemoval() {
        String block = """
                doe \
                deer""";

        assertThat(block.lines().count()).isEqualTo(1L);
    }

    @Test
    void newlineInsideMultiline() {
        String block = """
                doe \n
                deer
                """;

        assertThat(block.lines().count()).isEqualTo(3L);
    }

    @Test
    void essentialWhitespaces() {
        String block = """
                 "doe\"\"\"
                 \"deer\"""
                """;

        assertThat(block.lines().count()).isEqualTo(2L);
    }

}