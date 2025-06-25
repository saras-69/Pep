import java.util.Arrays;

public class PrimsMST {
    int V;
    int[][] graph;

    PrimsMST(int V) {
        this.V = V;
        this.graph = new int[V][V];

    }

    public int primsMST(int start, int[][] graph) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        int[] cost = new int[V];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = graph[start][start];
        int totalCost = 0;

        for (int i = 0; i < V; i++) {
            int u = minVertex(visited, cost);
            if (u == -1)
                break;

            visited[u] = true;
            totalCost += cost[u];

            // Update adjacent vertices' costs
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < cost[v]) {
                    cost[v] = graph[u][v];
                }
            }
        }
        return totalCost;
    }

    public int minVertex(boolean[] visited, int[] cost) {
        int min = Integer.MAX_VALUE;
        int vertex = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i] && cost[i] < min) {
                min = cost[i];
                vertex = i;
            }
        }
        return vertex;
    }

}
