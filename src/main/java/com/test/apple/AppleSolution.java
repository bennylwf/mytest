package com.test.apple;

import java.util.*;


class AppleSolution {
    public int solution(int[] A, int K, int L) {

        int size = A.length;

        if (size < K + L) {
            return -1;
        }

        ArrayList<SelectedTrees> aliceTrees = new ArrayList();
        ArrayList<SelectedTrees> bobTrees = new ArrayList();
        for (int i = 0; i < size; i++) {

            if (i <= size - K) {
                populatePossibleTrees(A, K, aliceTrees, i);
            }

            if (i <= size - L) {
                populatePossibleTrees(A, L, bobTrees, i);
            }
        }

        int result = calByFilterOverlap(K, L, aliceTrees, bobTrees);


        System.out.println(String.format("The max result2 is : %d", result));

        return result;

    }

    /**
     * Populates all possible combinations that Alice/Bob can select
     * @param A
     * @param targetNum
     * @param possibleSelectedTrees
     * @param i
     */
    private void populatePossibleTrees(int[] A, int targetNum, ArrayList<SelectedTrees> possibleSelectedTrees, int i) {
        SelectedTrees selectedTrees = new SelectedTrees();
        selectedTrees.firstTreeIndex = i;

        for ( int aIndex = 0; aIndex < targetNum; aIndex ++ ) {
            selectedTrees.count += A[i+ aIndex];
        }

        possibleSelectedTrees.add(selectedTrees);
    }

    /**
     * Filter out all any overlap select trees, and return the max
     * @param K
     * @param L
     * @param aliceTrees
     * @param bobTrees
     * @return
     */
    private int calByFilterOverlap(int K, int L, ArrayList<SelectedTrees> aliceTrees, ArrayList<SelectedTrees> bobTrees) {
        List<Integer> possibleResults = new ArrayList();

        for (SelectedTrees aliceTree : aliceTrees) {

            int aLastIndex = aliceTree.firstTreeIndex + K -1;
            for (SelectedTrees bobTree : bobTrees) {
                int bLastIndex = bobTree.firstTreeIndex +L -1;

                if (K <= L) {
                    if ( aliceTree.firstTreeIndex >= bobTree.firstTreeIndex && aliceTree.firstTreeIndex <= bLastIndex
                            || aLastIndex >= bobTree.firstTreeIndex && aLastIndex <= bLastIndex) {
                        continue;
                    }
                }

                if ( K>L) {
                    if (bobTree.firstTreeIndex >= aliceTree.firstTreeIndex && bobTree.firstTreeIndex <= aLastIndex
                            || bLastIndex >= aliceTree.firstTreeIndex && bLastIndex <= aLastIndex) {
                        continue;
                    }
                }

                possibleResults.add(bobTree.count + aliceTree.count);

            }
        }

        return possibleResults.stream().max(Comparator.comparingInt(o -> o)).get();
    }


    private static class SelectedTrees {
        int firstTreeIndex = 0;
        int count = 0;
    }



    public static void main(String[] args) {

        AppleSolution appleSolution = new AppleSolution();

        appleSolution.solution(new int[]{6,1,4,6,3,2,7,4}, 3, 2);  // should 24

        appleSolution.solution(new int[] {1, 7, 4, 1, 1, 4, 6, 3 }, 3, 2); //should 24

        appleSolution.solution(new int[]{5, 1, 7, 1, 2, 1, 6}, 3, 2); //should 20

        appleSolution.solution(new int[]{4, 4, 6, 3, 3, 8, 4, 2 }, 3, 2); //should 26

//        System.out.println(String.format("The max result is : %d", result));


    }


}
