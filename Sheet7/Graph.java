public class Graph {
    int V;
    int[][] graph;

    Graph(int V) {
        this.V = V;
        this.graph = new int[V][V];
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
