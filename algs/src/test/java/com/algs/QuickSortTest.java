package com.algs;

import org.junit.Test;

import static com.algs.SortUtils.SAMPLE_INPUT_SORTED;
import static com.algs.SortUtils.SAMPLE_INPUT_UNSORTED;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    private Sort quickSort = new QuickSort();

    @Test
    public void shouldSortElements() {
        Comparable[] sortedResult = SAMPLE_INPUT_UNSORTED;

        quickSort.sort(sortedResult);

        assertArrayEquals(SAMPLE_INPUT_SORTED, sortedResult);
    }
}