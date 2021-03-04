public class PrintLongestPalindromeSubsequence {
    // Function to find LCS of string `X[0…m-1]` and `Y[0…n-1]`
    public static String longestPalindrome(String X, String Y, int m, int n,
        int[][] T)
    {
        // return an empty string if the end of either sequence is reached
        if (m == 0 || n == 0) {
            return "";
        }

        // If the last character of `X` and `Y` matches
        if (X.charAt(m - 1) == Y.charAt(n - 1))
        {
            // append current character (`X[m-1]` or `Y[n-1]`) to LCS of
            // substring `X[0…m-2]` and `Y[0…n-2]`
            return longestPalindrome(X, Y, m - 1, n - 1, T) + X.charAt(m - 1);
        }

        // otherwise, if the last character of `X` and `Y` are different

        // if a top cell of the current cell has more value than the left
        // cell, then drop the current character of string `X` and find LCS
        // of substring `X[0…m-2]`, `Y[0…n-1]`

        if (T[m - 1][n] > T[m][n - 1]) {
            return longestPalindrome(X, Y, m - 1, n, T);
        }

        // if a left cell of the current cell has more value than the top
        // cell, then drop the current character of string `Y` and find LCS
        // of substring `X[0…m-1]`, `Y[0…n-2]`

        return longestPalindrome(X, Y, m, n - 1, T);
    }

    // Function to find the length of LCS of substring `X[0…n-1]` and `Y[0…n-1]`
    public static int LCSLength(String X, String Y, int n, int[][] T)
    {
        // Fill the lookup table in a bottom-up manner.
        // The first row and first column of the lookup table are already 0.
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // if current character of `X` and `Y` matches
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                }

                // otherwise, if the current character of `X` and `Y` don't match
                else {
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }
        return T[n][n];
    }

    public static void main(String[] args)
    {
        String X = "ABBDCACB";

        // string `Y` is a reverse of `X`
        String Y = new StringBuilder(X).reverse().toString();

        // `T[i][j]` stores the length of LCS of substring `X[0…i-1]` and `Y[0…j-1]`
        int[][] T = new int[X.length() + 1][X.length() + 1];

        // find the length of the LPS using LCS
        System.out.println("The length of the longest palindromic subsequence is "
            + LCSLength(X, Y, X.length(), T));

        // print the LPS using a lookup table
        System.out.println("The longest palindromic subsequence is "
            + longestPalindrome(X, Y, X.length(), X.length(), T));
    }
}
