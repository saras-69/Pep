import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution for LeetCode 778: Swim in Rising Water
 * 
 * Problem: Return the least time until you can reach the bottom right square
 * (n-1, n-1) if you start at the top left square (0, 0). You can swim at time t
 * only
 * through cells with elevation <= t.
 */
public class SwimInRisingWater {

    // Define a Pair class to store cell information
    static class Pair implements Comparable<Pair> {
        int depth;
        int row;
        int col;

        Pair(int depth, int row, int col) {
            this.depth = depth;
            this.row = row;
            this.col = col;
        }

        // Implement compareTo for PriorityQueue to sort by depth
        @Override
        public int compareTo(Pair other) {
            return this.depth - other.depth;
        }
    }

    /**
     * Solution using a Pair class and PriorityQueue
     */
    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Pair> q = new PriorityQueue<>();

        // Add starting point with its elevation
        q.add(new Pair(grid[0][0], 0, 0));

        // Directions: right, left, down, up
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            Pair removed = q.poll();
            int x = removed.row;
            int y = removed.col;
            int d = removed.depth;

            // If we've reached the destination
            if (x == n - 1 && y == n - 1) {
                return d;
            }

            // Skip if already visited
            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            // Explore all four directions
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // Check if the position is valid and not visited
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    // The maximum depth needed is the max of current depth and new cell's height
                    int newDepth = Math.max(d, grid[nx][ny]);
                    q.add(new Pair(newDepth, nx, ny));
                }
            }
        }

        return -1; // Should never reach here if grid is valid
    }

    /**
     * Alternative solution using int[] array instead of custom Pair class
     */
    public static int swimInWaterAlternative(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        // Each entry is [row, col, max elevation]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] { 0, 0, grid[0][0] });

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int maxSoFar = current[2];

            if (row == n - 1 && col == n - 1) {
                return maxSoFar;
            }

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n
                        && !visited[newRow][newCol]) {
                    int newMaxHeight = Math.max(maxSoFar, grid[newRow][newCol]);
                    pq.offer(new int[] { newRow, newCol, newMaxHeight });
                }
            }
        }

        return -1;
    }

    /**
     * Third approach: Using Binary Search with BFS
     * The idea is to binary search for the minimum water level needed
     * and use BFS to check if we can reach the target at that water level.
     */
    public static int swimInWaterWithBinarySearch(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0]; // Minimum possible water level is the starting cell
        int right = n * n - 1; // Maximum possible value in the grid

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if we can reach the bottom-right corner with water level 'mid'
            if (canReachDestination(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Helper method to check if we can reach the destination with given water level
    private static boolean canReachDestination(int[][] grid, int waterLevel) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        // If the starting point has height greater than waterLevel, we cannot start
        if (grid[0][0] > waterLevel) {
            return false;
        }

        // Directions: right, left, down, up
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // Check if we've reached the destination
            if (row == n - 1 && col == n - 1) {
                return true;
            }

            // Explore all four directions
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check if valid position, not visited, and height is at most waterLevel
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n
                        && !visited[newRow][newCol] && grid[newRow][newCol] <= waterLevel) {

                    queue.add(new int[] { newRow, newCol });
                    visited[newRow][newCol] = true;
                }
            }
        }

        return false; // Cannot reach destination
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] grid1 = {
                { 0, 2 },
                { 1, 3 }
        };
        System.out.println("Test Case 1 Output (PQ): " + swimInWater(grid1));
        System.out.println("Test Case 1 Output (Alternative): " + swimInWaterAlternative(grid1));
        System.out.println("Test Case 1 Output (Binary Search): " + swimInWaterWithBinarySearch(grid1));
        // Expected output: 3

        // Test case 2
        int[][] grid2 = {
                { 0, 1, 2, 3, 4 },
                { 24, 23, 22, 21, 5 },
                { 12, 13, 14, 15, 16 },
                { 11, 17, 18, 19, 20 },
                { 10, 9, 8, 7, 6 }
        };
        System.out.println("Test Case 2 Output (PQ): " + swimInWater(grid2));
        System.out.println("Test Case 2 Output (Alternative): " + swimInWaterAlternative(grid2));
        System.out.println("Test Case 2 Output (Binary Search): " + swimInWaterWithBinarySearch(grid2));
        // Expected output: 16
    }
}
