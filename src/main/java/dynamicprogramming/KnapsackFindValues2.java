package dynamicprogramming;

public class KnapsackFindValues2 {
        // Input:
        // Values (stored in array `v`)
        // Weights (stored in array `w`)
        // Total number of distinct items `n`
        // Knapsack capacity `W`
        public static int knapsack(int[] v, int[] w, int W)
        {
            // `T[i][j]` stores the maximum value of knapsack having weight
            // less than equal to `j` with only first `i` items considered.
            int[][] T = new int[v.length + 1][W + 1];

            // do for i'th item
            for (int i = 1; i <= v.length; i++)
            {
                // consider all weights from 0 to maximum capacity `W`
                for (int j = 0; j <= W; j++)
                {
                    // don't include the i'th element if `j-w[i-1]` is negative
                    if (w[i-1] > j) {
                        T[i][j] = T[i-1][j];
                        System.out.print(T[i][j] + " ");
                    }
                    else {
                        // find the maximum value we get by excluding or including
                        // the i'th item
                        T[i][j] = Integer.max(T[i-1][j], T[i-1][j-w[i-1]] + v[i-1]);
                        System.out.print(T[i][j] + " ");
                    }
                }
                System.out.println(" ");
            }


            // return maximum value
            return T[v.length][W];
        }

        public static void main(String[] args)
        {
            // input: a set of items, each with a weight and a value
            int[] v = { 20, 5, 10, 40, 15, 25 };
            int[] w = { 1, 2, 3, 8, 7, 4 };

            // knapsack capacity
            int W = 10;

            System.out.println("Knapsack value is " + knapsack(v, w, W));
        }
    }
