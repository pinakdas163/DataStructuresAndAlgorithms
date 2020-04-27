package com.daspinak.algorithms.sorting;

class MergeSort {
    // Takes in an array that has two sorted subarrays,
    //  from [p..q] and [q+1..r], and merges the array
    static void merge(int array[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] subarr1 = new int[n1];
        int[] subarr2 = new int[n2];
        int i , j, k;
        for (i = 0; i < n1; i++) {
            subarr1[i] = array[p + i];
        }

        for (j = 0; j < n2; j++) {
            subarr2[j] = array[q + 1 + j];
        }

        i = 0;
        j = 0;
        k = p;
        while (i < subarr1.length && j < subarr2.length) {
            if (subarr1[i] <= subarr2[j]) {
                array[k] = subarr1[i];
                i++;
            } else {
                array[k] = subarr2[j];
                j++;
            }
            k++;
        }

        while (j < subarr2.length) {
            array[k] = subarr2[j];
            j++;
            k++;
        }
        while (i < subarr1.length) {
            array[k] = subarr1[i];
            i++;
            k++;
        }
    }

    // Takes in an array and recursively merge sorts it
    public static void mergeSort(int[] array, int p, int r) {
        // Write this method
        if (p >= r) {
            return;
        } else {
            int q = (p + r)/2;
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            merge(array, p, q, r);
        }
    };
}