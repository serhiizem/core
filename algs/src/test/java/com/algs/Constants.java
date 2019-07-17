package com.algs;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

final class Constants {

    static final int SAMPLE_PRIMES_CEILING = 25;

    static final Map<Integer, List<Integer>> CORRECT_RESULTS_FOR_PRIMES_GENERATION =
            ImmutableMap.<Integer, List<Integer>>builder()
                    .put(SAMPLE_PRIMES_CEILING, Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23))
                    .build();


    static final Comparable[] SAMPLE_INPUT_UNSORTED =
            new Integer[]{5, 1, 7, 2, 5, 4, 9, 3};

    static final Comparable[] SAMPLE_INPUT_SORTED =
            new Integer[]{1, 2, 3, 4, 5, 5, 7, 9};

    private Constants() {
    }
}
