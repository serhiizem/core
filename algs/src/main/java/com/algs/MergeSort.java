package com.algs;

import static java.lang.System.arraycopy;

public class MergeSort implements Sort {

    @Override
    public Comparable[] sort(Comparable[] input) {

        if (input.length <= 1) {
            return input;
        }

        Comparable[] first = new Comparable[input.length / 2];
        Comparable[] second = new Comparable[input.length - first.length];

        arraycopy(input, 0, first, 0, first.length);
        arraycopy(input, first.length, second, 0, second.length);

        sort(first);
        sort(second);

        merge(first, second, input);

        return input;
    }

    private void merge(Comparable[] first, Comparable[] second, Comparable[] result) {

        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;

        while (iFirst < first.length && iSecond < second.length) {
            //noinspection unchecked
            if (first[iFirst].compareTo(second[iSecond]) < 0) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }

        arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }
}
