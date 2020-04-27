package com.daspinak.algorithms.sorting;

public class QuickSort {
    private static int partition(int[] arr, int p, int r) {
        int q = p;
        int j = p;

        while (j < r) {
            if (arr[j] < arr[r]) {
                int t = arr[j];
                arr[j] = arr[q];
                arr[q] = t;
                q++;
            }
            j++;
        }

        int t = arr[j];
        arr[j] = arr[q];
        arr[q] = t;

        return q;
    }

    public static void quickSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        } else {
            int q = partition(arr, p, r);
            quickSort(arr, p, q-1);
            quickSort(arr, q+1, r);
        }
    }

    public static void spread(int[] arr) {
        int j = 0;
        int q = 0;
        int n = arr.length - 1;

        while (j <= n) {
            if (arr[j] < 0) {
                int temp = arr[q];
                arr[q] = arr[j];
                arr[j] = temp;
                q++;
            }
            j++;
        }
    }
}
