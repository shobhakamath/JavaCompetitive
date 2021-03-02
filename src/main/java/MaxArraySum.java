public class MaxArraySum {
    public static void main(String[] args) {

    }

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int maxSum = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum = Math.max(arr[i] + maxSum, maxSum);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
