package org.core.practice.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumTest {


    // Input: nums = [2,7,11,15], target = 9
    // Output: [0,1]
    // Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    @Test
    void test() {
        int target = 9;
        int[] nums = new int[]{2, 7, 11, 15};

        var indexes = TwoSum.findIndexes(nums, target);

        assertThat(indexes).isEqualTo(new int[]{0, 1});
    }
}
