public class MinClosestPair {
    public static void main(String[] args) {
        int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        System.out.println(printClosestPair(ar1,ar2,32));
    }
//https://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/
    static int[] printClosestPair(int[] m, int[] n, int value) {
        int minValue = Integer.MAX_VALUE;
        int[] thepair = new int[2];
        int count = 0;
        int i = 0, j = n.length-1;
        while (count <= m.length + n.length) {
            int sum = m[i] + n[j];
            if (value-sum>0 && value-sum < minValue) {
                thepair[0] = m[i];
                thepair[1] = n[j];
                minValue = value - sum;
            }
            if (m[i] + n[j]>value) {
                i++;
            } else {
                j--;
            }
        }
        return thepair;
    }
}
