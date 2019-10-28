package com.test.sort;

public class InsertSort {
    public static void insertSort(int[] arr)
    {
        if(arr == null || arr.length == 0)
        {
            return;
        }
        for(int i = 1;i < arr.length;i++)
        {
            int j;
            int tmp = arr[i];
            System.out.println(String.format("Out loop, prcessing index %d, value %s", i, arr[i]));
            for(j = i;j > 0 && arr[j - 1] > tmp;j--)
            {
                System.out.println(String.format("Inner loop, move value %s", arr[j-1]));
                arr[j] = arr[j - 1];
            }
            System.out.println(String.format("Put the value to %d", j));
            arr[j] = tmp;
        }
    }
    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,7,3,1,8,9,5};
        insertSort(arr);
        for(int i:arr)
        {
            System.out.print(i + " ");
        }
    }
}

