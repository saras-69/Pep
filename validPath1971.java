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
