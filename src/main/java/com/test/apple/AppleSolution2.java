package com.test.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleSolution2 {

    public static void function(Integer[] a, int k, int l) {
        int totalOfKAndL = 0;

        Integer[] maxAndStartingIndex = getMaxContiguosFromArray(a, k);
        totalOfKAndL += maxAndStartingIndex[0];
//        System.out.println(maxAndStartingIndex[0]);
        Integer[] leadingElements = Arrays.copyOfRange(a, 0, maxAndStartingIndex[1]);
        Integer[] trailingElements = Arrays.copyOfRange(a, (maxAndStartingIndex[1] + k), a.length);

        List<Integer> mergedLeadingAndTrailingElements = new ArrayList(Arrays.asList(leadingElements));
        mergedLeadingAndTrailingElements.addAll(Arrays.asList(trailingElements));
        Integer[] mergedLeadingAndTrailingElementsArray = mergedLeadingAndTrailingElements.toArray(new Integer[0]);

        maxAndStartingIndex = getMaxContiguosFromArray(mergedLeadingAndTrailingElementsArray, l);
//        System.out.println(maxAndStartingIndex[0]);
        totalOfKAndL += maxAndStartingIndex[0];
        System.out.println(totalOfKAndL);
    }

    static Integer[] getMaxContiguosFromArray(Integer[] a, int numberOrElements) {
        int sumForFirst = 0;
        int sumForFirstPrev = 0;
        int startingIndexForK = 0;
        Integer[] maxAndStartingIndex = new Integer[2];
        for (int i = 0; i < a.length; i++) {
            if (i <= a.length - numberOrElements) {
                for (int j = i; j < i + numberOrElements; j++) {
                    sumForFirst += a[j];
                }
            }

            if (sumForFirst > sumForFirstPrev) {
                sumForFirstPrev = sumForFirst;
                startingIndexForK = i;

            }
            sumForFirst = 0;
        }
        maxAndStartingIndex[0] = sumForFirstPrev;
        maxAndStartingIndex[1] = startingIndexForK;
        return maxAndStartingIndex;
    }

    public static void main(String[] args) {
        Integer a[] = {6, 1, 3, 4, 5, 6, 8, 2, 7};

        function(a, 3, 2); //should 28


        function(new Integer[]{6, 1, 4, 6, 3, 2, 7, 4}, 3, 2);  //should 24
        function(new Integer[]{1, 7, 4, 1, 1, 4, 6, 3 }, 3, 2);   //This should return same '24' as above case

        function(new Integer[]{5, 1, 7, 1, 2, 1, 6}, 3, 2); //should 20

        function(new Integer[]{4, 4, 6, 3, 3, 8, 4, 2 }, 3, 2); //Fixme, should 26, but 25


    }
}

