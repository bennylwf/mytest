package com.test.slice;

public class MaxSlice {

    public static void main(String[] args) {

        solution(new int[] {5, -7, 3, 5, -2, 4, -1});

    }


    public static int solution(int[] A) {

        int result = 0;

        int max_ending = 0;

        for (int i= 0; i< A.length ; i++) {
                max_ending = Math.max(0, max_ending + A[i]);
                result = Math.max( result, max_ending);
        }

        System.out.println("The result is : " + result);

        return result;
    }


}
