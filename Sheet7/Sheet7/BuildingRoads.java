import java.util.*;

public class BuildingRoads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            uf.union(a, b);
        }

        List<Integer> components = uf.getComponents();
        int k = components.size() - 1;
        System.out.println(k);

        for (int i = 0; i < k; i++) {
            System.out.println((components.get(i) + 1) + " " + (components.get(i + 1) + 1));
        }

        sc.close();
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public List<Integer> getComponents() {
        Set<Integer> uniqueComponents = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            uniqueComponents.add(find(i));
        }
        return new ArrayList<>(uniqueComponents);
    }
}
