import java.util.*;

public class Main {
    static long Ways(int n, int[] c) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int coin : c) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] coins = new int[m];

        for (int i = 0; i < m; i++) {
            coins[i] = scanner.nextInt();
        }

        System.out.println(Ways(n, coins));
    }
}
