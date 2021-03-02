package dynamicprogramming;
import java.util.*;

public class KnapsackValues3 {

        // Input:
        // Values (stored in array v)
        // Weights (stored in array w)
        // Number of distinct items (n)
        // Knapsack capacity (cap)
        public static int knapSack(int[] v, int[] w, int cap) {
            int n = v.length;
            int[][] T = new int[n + 1][cap + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= cap; j++) {
                    if (j < w[i - 1]) {

                        T[i][j] = T[i - 1][j];
                        System.out.print(T[i][j] + " ");
                    } else {
                        T[i][j] = Math.max(T[i][j-1],
                            v[i -1] + T[i - 1][j - w[i - 1]]);
                        System.out.print(T[i][j] + " ");
                    }
                }
                System.out.print("\n");
            }

            int temp = cap;
            for (int i = n; i > 0 && temp > 0; i--)  {
                //this item do not contribute to result
                if (T[i][temp] == T[i - 1][temp]) {
                    continue;
                } else {
                    System.out.print(w[i - 1] + ", ");
                    temp -= w[i - 1];
                }
            }
            System.out.println("These weights contribute to result");
            return T[n][cap];
        }

        public static void main(String[] args) {
            // Input: set of items each with a weight and a value
            int[] v = { 20, 5, 10, 40, 15, 25 };
            int[] w = { 1, 2, 3, 8, 7, 4 };

            // Knapsack capacity
            int cap = 10;

            System.out.println("Knapsack value is " + knapSack(v, w, cap));


            int[] v1 = { 20, 5, 10, 40, 15, 25 };
            int[] w1 = { 1, 2, 4, 8, 7, 5 };

            // Knapsack capacity
            int cap1 = 12;

            System.out.println("Knapsack value is " + knapSack(v1, w1, cap1));
        }
    }
