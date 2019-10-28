package com.test.apple;

import java.util.HashMap;
import java.util.Map;

public class AppleSolution3 {

    private static int solution(int[] A, int K, int L) {
        if (K + L > A.length)
            return -1;

        int sum, aliceApples, bobApples, totalApples = 0;

        HashMap<Integer, Integer> aliceMap = new HashMap<>(), bobMap = new HashMap<>();

        //  populate alice map
        for (int i = 0; i < A.length; i++) {
            sum = 0;
            if (K + i > A.length)
                break;
            for (int j = i; j < K + i; j++) {
                sum += A[j];
            }
            aliceMap.put(i, sum);
        }

        //  populate bob map
        for (int i = 0; i < A.length; i++) {
            sum = 0;
            if (L + i > A.length)
                break;
            for (int j = i; j < L + i; j++) {
                sum += A[j];
            }
            bobMap.put(i, sum);
        }

        //  iterate through maps
        for (Map.Entry<Integer, Integer> aliceEntry : aliceMap.entrySet()) {
            bobApples = 0;
            aliceApples = aliceEntry.getValue();
//            System.out.println("--- : aliceApples: " + aliceApples);
            if (aliceEntry.getKey() + K < bobMap.size()) {
                for (int i = aliceEntry.getKey() + K; i < bobMap.size(); i++) {   //FIXME: This is wrong!, bob's L shouldn't always after Alice's K
                    if (bobApples < bobMap.get(i))
                        bobApples = bobMap.get(i);
//                    System.out.println("--- : bobApples: " + bobApples);
                }
                if (totalApples < aliceApples + bobApples)
                    totalApples = aliceApples + bobApples;
//                System.out.println("--- total Apples: " + totalApples);
            }
        }
        return totalApples;
    }

    public static void main(String[] args) {

        System.out.println("--- total collected apples: " + solution(new int[]{6, 1, 4, 6, 3, 2, 7, 4}, 3, 2));  //should 24
        System.out.println("--- total collected apples: " + solution(new int[]{1, 7, 4, 1, 1, 4, 6, 3 }, 3, 2));   // FIXME: This should return same '24' as above case, not 22
        System.out.println("--- total collected apples: " + solution(new int[]{5, 1, 7, 1, 2, 1, 6}, 3, 2));  //should 20
        System.out.println("--- total collected apples: " + solution(new int[]{4, 4, 6, 3, 3, 8, 4, 2}, 3, 2)); //should 26
    }
}
