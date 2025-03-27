import java.util.Scanner;

public class NumberOfIslands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the dimensions of the grid
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Read the grid
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        // Calculate the number of islands
        int numIslands = numIslands(grid);
        System.out.println(numIslands);

        sc.close();
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return numIslands;
    }

    private static void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // Mark the cell as visited

        dfs(grid, i - 1, j, m, n); // Up
        dfs(grid, i + 1, j, m, n); // Down
        dfs(grid, i, j - 1, m, n); // Left
        dfs(grid, i, j + 1, m, n); // Right
    }
}