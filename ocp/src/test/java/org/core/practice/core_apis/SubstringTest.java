package org.core.practice.core_apis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubstringTest {

    @Test
    void substringOfSameStartEndIndexes() {
        String name = "animals";

        assertThat(name.substring(3, 3)).isEqualTo("");
    }
}
