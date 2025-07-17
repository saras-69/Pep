import java.util.Arrays;

public class TSP {
    static int n;
    static int[][] dist;
    static int[][] dp;

    public static int findMinCostPath(int mask, int pos) {
        // 1. When all the cities are visited
        if (mask == (1 << n) - 1)
            return dist[pos][0];
        // 2. if the ans already exists, return the ans
        if (dp[mask][pos] != -1)
            return dist[mask][pos];
        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) { // check if the city is not visited
                int newAns = dist[pos][city] + findMinCostPath((mask | (1 << city)), city); // (mask | (1 << city) =
                                                                                            // mark city visited
                ans = Math.min(ans, newAns);
            }
        }
        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {
        n = 4;
        dist = new int[][] {
                { 0, 1, 15, 6 },
                { 2, 0, 7, 3 },
                { 9, 6, 0, 12 },
                { 10, 4, 8, 0 }
        };
        dp = new int[1 << n][n];
        for (int i = 0; i < (1 << n); i++)
            Arrays.fill(dp[i], -1);
        System.out.println(findMinCostPath(1, 0));
        // printing the dp table
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }
}