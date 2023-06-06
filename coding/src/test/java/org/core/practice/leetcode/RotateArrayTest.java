package org.core.practice.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RotateArrayTest {

    @Test
    void test1() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int step = 3;

        int[] result = RotateArray.rotate(input, step);

        assertThat(result).isEqualTo(new int[]{5, 6, 7, 1, 2, 3, 4});
    }

    @Test
    void test2() {
        int[] input = {-1, -100, 3, 99};
        int step = 2;

        int[] result = RotateArray.rotate(input, step);

        assertThat(result).isEqualTo(new int[]{3, 99, -1, -100});
    }
}