import java.util.Arrays;

public class LongestCommonPalindomeSubstring {

        public int dp [][];

    public int longestPalindromeSubseqTopDown (String s) {
        int N = s.length ();
        if (N <= 1)
            return N;
        String A = s;
        String B = new StringBuilder (s).reverse ().toString ();
        int dp [][] = new int [N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (A.charAt (i-1) == B.charAt (j-1))
                    dp [i][j] = dp [i-1][j-1] + 1;
                else
                    dp [i][j] = Math.max (dp [i-1][j], dp [i][j-1]);
            }
        }
        return dp [N][N];
    }

        public int longestPalindromeSubseqBottomUp(String s) {
            if (s == null || s.length () == 0)
                return 0;
            if (s.length () == 1)
                return 1;
            String A = s;
            String B = new StringBuilder(s).reverse().toString();
            dp = new int [A.length () + 1][B.length () + 1];
            for (int arr [] : dp)
                Arrays.fill (arr, -1);
            return LCS (A, B, A.length (), B.length ());
        }

        public int LCS (String A, String B, int a, int b) {
            if (a == 0 || b == 0)
                return 0;
            if (dp [a][b] != -1)
                return dp [a][b];
            if (A.charAt (a-1) == B.charAt (b-1))
                return dp [a][b] = (LCS (A, B, a-1, b-1) + 1);
            else
                return dp [a][b] = (Math.max (LCS (A, B, a-1, b), LCS (A, B, a, b-1)));
        }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPalindomeSubstring().longestPalindromeSubseqBottomUp("ABCCBA"));
        System.out.println(new LongestCommonPalindomeSubstring().longestPalindromeSubseqTopDown("ABCCBA"));
    }
}
