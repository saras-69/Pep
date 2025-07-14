
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numEdges = sc.nextInt();

        int[][] bg = new int[numEdges][2];
        for (int i = 0; i < numEdges; i++) {
            bg[i][0] = sc.nextInt();
            bg[i][1] = sc.nextInt();
        }

        int[] result = connectedComponents(bg);

        System.out.println(result[0] + " " + result[1]);

    }

    public static int[] connectedComponents(int[][] bg) {
        Set<Integer> allNodes = new HashSet<>();
        for (int[] edge : bg) {
            allNodes.add(edge[0]);
            allNodes.add(edge[1]);
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int node : allNodes) {
            graph.put(node, new ArrayList<>());
        }
        for (int[] edge : bg) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Set<Integer> visited = new HashSet<>();
        List<Integer> componentSizes = new ArrayList<>();

        for (int node : allNodes) {
            if (!visited.contains(node)) {
                int componentSize = dfs(node, graph, visited);
                if (componentSize >= 2) {
                    componentSizes.add(componentSize);
                }
            }
        }
        int minSize = Collections.min(componentSizes);
        int maxSize = Collections.max(componentSizes);

        return new int[] { minSize, maxSize };
    }

    private static int dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        int size = 1;
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                size += dfs(neighbor, graph, visited);
            }
        }

        return size;
    }

}