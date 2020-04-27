package com.daspinak.algorithms.sorting;

public class SelectionSort {
    public static int indexOfMinimum(int[] array, int startIndex) {
        int length = array.length;
        if (startIndex < length) {
            int minValue = array[startIndex];
            int minIndex = startIndex;
            for (int i = startIndex; i < length; i++) {
                if (minValue > array[i]) {
                    minValue = array[i];
                    minIndex = i;
                }
            }

            return minIndex;
        } else {
            return -1;
        }
    }
    public static void swap(int[] array, int firstIndex, int secondIndex) {
        if (array.length > firstIndex && array.length > secondIndex) {
            int temp = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = temp;
        }

        return;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int currIndValue = array[i];
            int indMin = indexOfMinimum(array, i);
            if (currIndValue > array[indMin]) {
                swap(array, indMin, i);
            }
        }
    }
}
