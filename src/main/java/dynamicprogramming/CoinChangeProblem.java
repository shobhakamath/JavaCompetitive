package dynamicprogramming;

public class CoinChangeProblem {


        // Function to find the total number of ways to get a change
        // of `N` from an unlimited supply of coins in set `S`
        public static int count(int[] S, int N)
        {
            // if the total is 0, return 1
            if (N == 0) {
                return 1;
            }

            // return 0 if total becomes negative
            if (N < 0) {
                return 0;
            }

            // initialize the total number of ways to 0
            int res = 0;

            // do for each coin
            for (int i = 0; i < S.length; i++)
            {
                // recur to see if total can be reached by including
                // current coin `S[i]`
                res += count(S, N - S[i]);
            }

            // return the total number of ways
            return res;
        }

        public static void main(String[] args)
        {
            // `n` coins of given denominations
            int[] S = { 1, 2, 3 };

            // total change required
            int N = 4;

            System.out.println("The total number of ways to get the desired change is "
                + count(S, N));
        }
    }
