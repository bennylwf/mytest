import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


class DemoSolution {
    public int solution(int[] A) {

//        int max = Arrays.stream(A).parallel().max().getAsInt();
//        if (max <= 0 ) {
//            return 1;
//        }

        Set<Integer> mySet = Arrays.stream(A).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= A.length; i++ ) {
            if (!mySet.contains(i)) {
                return i;
            }
        }

        return A.length + 1;
    }


    public static void main(String[] args) {


//        int[] inputs = {1, 3, 6, 4, 1, 2};

//        int[] inputs = {1, 2, 3};

        int[] inputs = {-1, 3};


        DemoSolution mySolution = new DemoSolution();

        int result = mySolution.solution( inputs );


        System.out.println(String.format("The result is %d", result ));

    }

}
