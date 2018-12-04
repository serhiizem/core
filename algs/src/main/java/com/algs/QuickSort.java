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
        int pivot = this.partition(input, left, right);

        if (left < pivot - 1) {
            this.quickSort(input, left, pivot - 1);
        }
        if (right > pivot) {
            this.quickSort(input, pivot, right);
        }
        return input;
    }

    private int partition(Comparable[] input, int left, int right) {

        int i = left;
        int j = right;
        Comparable pivot = input[(left + right) / 2];

        while (i <= j) {
            while (input[i].compareTo(pivot) < 0) {
                i++;
            }
            while (input[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                Comparable temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
}
