package com.algs;

import org.junit.jupiter.api.Test;

import static com.algs.Constants.SAMPLE_INPUT_SORTED;
import static com.algs.Constants.SAMPLE_INPUT_UNSORTED;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    private Sort mergeSort = new MergeSort();

    @Test
    public void shouldSortElements() {
        Comparable[] sortedResult = SAMPLE_INPUT_UNSORTED;

        mergeSort.sort(sortedResult);

        assertArrayEquals(SAMPLE_INPUT_SORTED, sortedResult);
    }
}