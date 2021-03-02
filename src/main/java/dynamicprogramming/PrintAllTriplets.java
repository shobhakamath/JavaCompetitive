package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintAllTriplets {

    // Function to print all distinct triplets in the array with a sum
    // less than or equal to a given number
    public static void printAllTriplets(int[] A, int sum) {
        // sort the array in ascending order
        Arrays.sort(A);

        // check if triplet is formed by `A[i]` and a pair from
        // subarray `A[i+1…n)`
        for (int i = 0; i <= A.length - 3; i++) {
            // maintain two indexes pointing to endpoints of the
            // subarray `A[i+1…n)`
            int low = i + 1, high = A.length - 1;

            // loop if `low` is less than `high`
            while (low < high) {
                // decrement `high` if the total is more than the remaining sum
                if (A[i] + A[low] + A[high] > sum) {
                    high--;
                } else {
                    // if the total is less than or equal to the remaining sum,
                    // print all triplets
                    for (int x = low + 1; x <= high; x++) {
                        System.out.println("(" + A[i] + ", " + A[low] + ", "
                            + A[x] + ")");
                    }

                    low++;    // increment low
                }
            }
        }
    }

    // Function to print all distinct triplets in the array with a sum
    // less than or equal to a given number
    public static void findAllTripletsBackTracking(List<Integer> input, int sum, int begin,
        List<Integer> comb, List<List<Integer>> res)
    {
        if (comb.size() == 3) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = begin; i < input.size() && input.get(i) <= sum; i++) {
            comb.add(input.get(i));
            findAllTripletsBackTracking(input, sum - input.get(i), i + 1, comb, res);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] A = { 2, 7, 4, 9, 5, 1, 3 };
        int sum = 10;

        printAllTriplets(A, sum);


        List<Integer> input = Arrays.asList(2, 7, 4, 9, 5, 1, 3); // 1 2 3 4 5 7 9

        // sort the input
        Collections.sort(input);
        List<Integer> comb = new ArrayList<>();

        // find all distinct triplets
        List<List<Integer>> result = new ArrayList<>();
        findAllTripletsBackTracking(input, sum, 0, comb, result);
        System.out.println("Backtracking method: ");
        // print all triplets
        for (List<Integer> triplet: result) {
            System.out.println("(" + triplet.get(0) + ", " +
                triplet.get(1) + ", " + triplet.get(2) + ")");
        }
    }
}
