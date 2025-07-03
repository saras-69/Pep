import java.util.*;

public class Solution {

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] len = new int[n + 1];
        Arrays.fill(len, -1);
        Queue<Integer> queue = new LinkedList<>();
        len[s] = 0;
        queue.add(s);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neig : adj.get(currentNode)) {
                if (len[neig] == -1) {
                    len[neig] = len[currentNode] + 6;
                    queue.add(neig);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == s) {
                continue;
            }
            result.add(len[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        for (int k = 0; k < q; k++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Integer> edge = new ArrayList<>();
                edge.add(scanner.nextInt());
                edge.add(scanner.nextInt());
                edges.add(edge);
            }

            int s = scanner.nextInt();

            List<Integer> result = Solution.bfs(n, m, edges, s);

            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i != result.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}