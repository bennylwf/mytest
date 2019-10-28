import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

import static java.lang.Math.sqrt;
import static java.util.stream.LongStream.rangeClosed;

public class Main {

    public static void main(String[] args) {


//        int[] inputs = {3, 4, 3, 0, 2, 2, 3, 0, 0};

        int[] inputs = IntStream.range(1, 100000).toArray();

        Solution mySolution = new Solution();

        int result = mySolution.solution( inputs );


        System.out.println(String.format("The result is %d", result ));

//        calDominator();
        testDeque();

    }




    public static int calDominator() {

        int[] array = { 3, 67, 23, 67, 67, 1, 1, 1,2, 2, 67,67 };
        int candidate=0;
        int counter = 0;

        // Find candidate for leader
        for(int i=0; i<array.length; i++){

            if(counter == 0) candidate = i;

            if(array[i] == array[candidate]){
                counter++;
            }else {
                counter--;
            }
        }

        // Count candidate occurrences in array
        counter = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] == array[candidate]) counter++;
        }

        // Check that candidate occurs more than array.lenght/2
        int result =  counter>array.length/2 ? candidate : -1;

        System.out.println(String.format("The dominator index is %d", result ));

        return result;

    }


    public static void testDeque() {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(4);
        stack.push(3);
        stack.push(1);
        stack.push(2);

        int head = stack.peek();
        int first = stack.getFirst();


        System.out.println(head);
        System.out.println(first);
    }



    private boolean isPrime(long n) {
        return n > 1 && rangeClosed(2, (long) sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }


//    private LocalDate getLocalDate(final @Nonnull Date date) {
//        // Convert the date using system default zone, as the iso-shared lib use the system timezone to
//        // convert the
//        // iso YYYY-MM-DD to Date object, now we have to use same zone to translate it back a LocalDate
//        // (YYYY-MM-DD)
//
//        return Optional.ofNullable(date).map(d -> d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
//                .orElse(null);
//    }
}
