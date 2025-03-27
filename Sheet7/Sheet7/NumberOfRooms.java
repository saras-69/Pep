package Sheet7;

import java.util.Scanner;

public class NumberOfRooms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int numRooms = countRooms(map, n, m);
        System.out.println(numRooms);

        sc.close();
    }

    public static int countRooms(char[][] map, int n, int m) {
        int numRooms = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '.') {
                    numRooms++;
                    dfs(map, i, j, n, m);
                }
            }
        }

        return numRooms;
    }

    private static void dfs(char[][] map, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || map[i][j] == '#') {
            return;
        }

        dfs(map, i - 1, j, n, m);
        dfs(map, i + 1, j, n, m);
        dfs(map, i, j - 1, n, m);
        dfs(map, i, j + 1, n, m);
    }
}