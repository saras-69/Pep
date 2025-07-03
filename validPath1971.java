import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean validPath1971(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        return dfs(list, visited, source, destination);
    }

    private boolean dfs(List<List<Integer>> list, boolean[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        }

        visited[source] = true;

        for (int neighbor : list.get(source)) {
            if (!visited[neighbor]) {
                if (dfs(list, visited, neighbor, destination)) {
                    return true;
                }
            }
        }

        return false;
    }
}

public class validPath1971 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
        int n1 = 3;
        int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        int source1 = 0;
        int destination1 = 2;
        System.out.println("Example 1: " + solution.validPath1971(n1, edges1, source1, destination1)); // Should return
                                                                                                       // true

        // Example 2: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0,
        // destination = 5
        int n2 = 6;
        int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } };
        int source2 = 0;
        int destination2 = 5;
        System.out.println("Example 2: " + solution.validPath1971(n2, edges2, source2, destination2)); // Should return
                                                                                                       // false
    }
}