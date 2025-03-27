package Sheet7;

import java.util.Scanner;

public class Frog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] h = new int[N];
        for (int i = 0; i < N; i++) {
            h[i] = sc.nextInt();
        }

        System.out.println(MinCost(h, N, 0));

        sc.close();
    }

    public static int MinCost(int[] h, int N, int i) {
        if (i == N - 1) {
            return 0;
        }
        if (i == N - 2) {
            return Math.abs(h[i] - h[i + 1]);
        }

        int x = Math.abs(h[i] - h[i + 1]) + MinCost(h, N, i + 1);
        int y = Math.abs(h[i] - h[i + 2]) + MinCost(h, N, i + 2);

        return Math.min(x, y);
    }
}
