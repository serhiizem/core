package com.algs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.algs.Constants.CORRECT_RESULTS_FOR_PRIMES_GENERATION;
import static com.algs.Constants.SAMPLE_PRIMES_CEILING;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimesGeneratorTest {

    private PrimesGenerator primesGenerator = new PrimesGenerator();

    @Test
    void shouldReturnEmptyResultIfCeilingIsLessThanTwo() {
        List<Integer> result = primesGenerator.generatePrimes(1);

        assertEquals(emptyList(), result);
    }

    @Test
    void shouldGeneratePrimesForSampleCeiling() {
        List<Integer> actual = primesGenerator.generatePrimes(SAMPLE_PRIMES_CEILING);

        List<Integer> expectedResult = CORRECT_RESULTS_FOR_PRIMES_GENERATION.get(SAMPLE_PRIMES_CEILING);

        assertEquals(expectedResult, actual);
    }
}
