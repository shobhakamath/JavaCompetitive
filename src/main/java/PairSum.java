import java.util.HashMap;
import java.util.Map;
//import java.util.stream.IntStream;

/**
 * Design an algorithm to find the pairs of integers within an array which sum to a specified value
 */
public class PairSum {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 0 };
        int sum = 7;
        new PairSum().pairSum(array, sum);
    }

    private void pairSum(int[] array, int sum) {
       /* Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, array.length).forEach(i -> {
            int foundIndex = map.getOrDefault(sum - array[i], -1);
            if (foundIndex != -1) {
               System.out.println(array[i] + " + " + array[foundIndex] + " = " + sum);
            }
            map.put(array[i], i);
    });*/
    }
}
