import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public int solution(int[] ranks) {

        List<Integer> distinctList = Arrays.stream(ranks).unordered().parallel().distinct().boxed().collect(Collectors.toList());
        distinctList.sort((o1, o2) -> o1 - o2);
        int result = 0;
        for (int index = 0; index < distinctList.size() - 1; index++) {

            Integer curValue = distinctList.get(index);
//            System.out.println(String.format("The sorted value :%d", curValue));
            if (curValue + 1 == distinctList.get(index + 1)) {
                for (int a : ranks) {
                    if (a == curValue) {
                        result++;
                    }
                }
            }

        }
        return result;


    }

    public int solution2(int[] ranks) {

        int result = 0;
        for (int rank : ranks) {

            for (int curRank : ranks) {

                if (curRank == rank + 1) {
                    result += 1;
                    break;
                }
            }
        }
        return result;

    }
}
