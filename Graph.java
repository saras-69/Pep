import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int V;
    int[][] graph;

    Graph(int V) {
        this.V = V;
        this.graph = new int[V][V];
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            {
                int removed = queue.remove();
                System.out.println(removed + " ");
                for (int i = 0; i < V; i++) {
                    if (graph[removed][i] == 1 && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;

                    }
                }
            }

        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.graph = new int[][] {
                { 0, 1, 0, 1, 0, 0 },
                { 1, 0, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 1, 0 }
        };
    }

}
