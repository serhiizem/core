package org.core.practice.core_apis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ConstantValue")
public class IndexOfTest {

    @Test
    void findIndexOf() {
        String name = "animals";

        assertThat(name.indexOf('a')).isEqualTo(0);
        assertThat(name.indexOf("al")).isEqualTo(4);
        assertThat(name.indexOf("al", 4)).isEqualTo(4);
        assertThat(name.indexOf("al", 5)).isEqualTo(-1);
    }
}
