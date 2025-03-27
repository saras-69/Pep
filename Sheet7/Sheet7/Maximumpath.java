package Sheet7;

import java.util.*;

public class Maximumpath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
            System.out.print(path(a, n, m, 0, 0));
        }
    }

    public static int path(int a[][], int n, int m, int i, int j) {
        if (i >= n || j >= m) {
            return Integer.MIN_VALUE;
        }
        if (i == n - 1 && j == m - 1) {
            return a[i][j];
        }

        return a[i][j] + Math.max(path(a, n, m, i, j + 1), path(a, n, m, i + 1, j));
    }
}
