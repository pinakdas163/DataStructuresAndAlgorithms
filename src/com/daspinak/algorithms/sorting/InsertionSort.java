package com.daspinak.algorithms.sorting;

public class InsertionSort {
    public static void insert(int[] array, int rightIndex, int value) {
        // write this method
        int i = rightIndex;
        for (; i >= 0 && value < array[i]; i--) {
            array[i+1] = array[i];
            System.out.println("first");
        }

        array[i+1] = value;
    }

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            insert(array, i-1, array[i]);
        }
    }
}
