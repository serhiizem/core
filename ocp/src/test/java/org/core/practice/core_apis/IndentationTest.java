package org.core.practice.core_apis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("TextBlockMigration")
public class IndentationTest {

    @Test
    void indentTextBlockAndAddNewline() {
        var block = """
            a
             b
            c""";

        assertThat(block.length()).isEqualTo(6);
        // adds three whitespaces and line break at the end of the string
        assertThat(block.indent(1).length()).isEqualTo(10);
        assertThat(block.indent(1)).isEqualTo(
                """
                         a
                          b
                         c
                        """
        );
    }

    @Test
    void removeIndentationFromStringAndAddNewlineAtTheEnd() {
        var block = " a\n" +
                "  b\n" +
                " c";

        assertThat(block.length()).isEqualTo(9);
        // adds three whitespaces and line break at the end of the string
        assertThat(block.indent(-1).length()).isEqualTo(7);
        assertThat(block.indent(-1)).isEqualTo(
                """
                        a
                         b
                        c
                        """
        );
    }

    @Test
    void removeAsMuchWhitespacesAsPossibleAndAddNewlineAtTheEnd() {
        var block = " a\n" +
                "  b\n" +
                " c";

        assertThat(block.length()).isEqualTo(9);
        assertThat(block.indent(-4).length()).isEqualTo(6);
        assertThat(block.indent(-4)).isEqualTo("""
                a
                b
                c
                """);
    }

    @Test
    @DisplayName("Removes the same number of incidental whitespaces from each line, " +
            "but does not add a newline at the end of the string")
    void removeTheSameNumberOfWhitespacesFromEachLineAndNotAddNewline() {
        var block = " a\n" +
                "  b\n" +
                " c";

        assertThat(block.length()).isEqualTo(9);
        assertThat(block.stripIndent().length()).isEqualTo(6);
        assertThat(block.stripIndent()).isEqualTo(
                """
                        a
                         b
                        c"""
        );
    }
}
