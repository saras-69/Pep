import java.util.Arrays;

public class MCM {
    public static int mcmRecursiveUtil(int[] arr, int i, int j, int[][] dp) {
        if (i == j)
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int ans = mcmRecursiveUtil(arr, i, k, dp) + mcmRecursiveUtil(arr, k + 1, j, dp)
                    + (arr[i - 1] * arr[k] * arr[j]);
            if (ans < min)
                min = ans;
        }

        return dp[i][j] = min;
    }

    public static int mcmRecursive(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], 0);
        return mcmRecursiveUtil(arr, 1, n - 1, dp);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 2, 2 };
        System.out.println(mcmRecursive(arr));
    }
}