package dynamicprogramming;
import java.util.ArrayDeque;
import java.util.Deque;

public class KnapsackFindValues {

        // Values (stored in array v)
        // Weights (stored in array w)
        // Number of distinct items (n)
        // Knapsack capacity W
        public static int knapSack(int[] v, int[] w, int n, int W, Deque<Integer> items)
        {
            // base case: Negative capacity
            if (W < 0) {
                return Integer.MIN_VALUE;
            }

            // base case: no items left or capacity becomes 0
            if (n < 0 || W == 0) {
                return 0;
            }

            // Take backup of current items in the Knapsack
            Deque<Integer> originalItems = new ArrayDeque<>(items);

            // Case 1. include current item n in knapSack (v[n]) and recur for
            // remaining items (n - 1) with decreased capacity (W - w[n])

            items.addLast(v[n]);
            int include = v[n] + knapSack(v, w, n - 1, W - w[n], items);

            // Case 2. exclude current item n from knapSack and recur for
            // remaining items (n - 1)
            int exclude = knapSack(v, w, n - 1, W, originalItems);

            // return maximum value we get by including or excluding current item
            if (include > exclude) {
                return include;
            }
            else {
                items.clear();
                items.addAll(originalItems);
                return exclude;
            }
        }

        // 0-1 Knapsack problem
        public static void main(String[] args)
        {
            // Input: set of items each with a weight and a value
            int[] v = { 20, 5, 10, 40, 15, 25 };
            int[] w = {  1, 2,  3,  8,  7, 4 };

            // Knapsack capacity
            int W = 10;

            // Deque to store the elements in Knapsack, if found
            Deque<Integer> items = new ArrayDeque<>();

            System.out.println("Knapsack value is " +
                knapSack(v, w, v.length - 1, W, items));

            System.out.println("Knapsack items are " + items);
        }
    }