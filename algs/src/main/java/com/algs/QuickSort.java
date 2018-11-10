package com.algs;

public class QuickSort implements Sort {

    @Override
    public Comparable[] sort(Comparable[] input) {
        if (input == null) {
            throw new IllegalArgumentException("Input array should not be null");
        }
        return this.quickSort(input, 0, input.length - 1);
    }

    private Comparable[] quickSort(Comparable[] input, int left, int right) {
        int index = this.partition(input, left, right);

        if (left < index - 1) {
            this.quickSort(input, left, index - 1);
        }
        if (right > index) {
            this.quickSort(input, index, right);
        }

        return input;
    }

    @SuppressWarnings("unchecked")
    private int partition(Comparable[] input, int lowerBound, int upperBound) {
        int first = lowerBound;
        int last = upperBound;
        Comparable pivot = input[(lowerBound + upperBound) / 2];

        while (first <= last) {

            while (input[first].compareTo(pivot) < 0) {
                first++;
            }
            while (input[last].compareTo(pivot) > 0) {
                last--;
            }

            if (first <= last) {
                Comparable temp = input[first];
                input[first] = input[last];
                input[last] = temp;
                first++;
                last--;
            }
        }
        return first;
    }
}
