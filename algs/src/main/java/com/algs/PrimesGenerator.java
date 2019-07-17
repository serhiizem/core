package com.algs;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class PrimesGenerator {

    public List<Integer> generatePrimes(int ceiling) {

        if (ceiling <= 1) {
            return emptyList();
        }

        boolean[] sieve = createSieve(ceiling);

        List<Integer> result = new ArrayList<>();

        for (int index = 2; index < sieve.length; index++) {
            if (isPrime(sieve[index])) {
                result.add(index);
                markNonPrimes(index, ceiling, sieve);
            }
        }

        return result;
    }

    private boolean[] createSieve(int ceiling) {
        boolean[] sieve = new boolean[ceiling + 1];
        for (int i = 2; i < sieve.length; i++) {
            sieve[i] = true;
        }
        return sieve;
    }

    private boolean isPrime(boolean isPrime) {
        return isPrime;
    }

    private void markNonPrimes(int startingIndex, int ceiling, boolean[] sieve) {
        for (int j = startingIndex * startingIndex; j <= ceiling; j += startingIndex) {
            sieve[j] = false;
        }
    }
}
