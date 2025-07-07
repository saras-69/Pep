import java.util.Scanner;

public class SegmentTree {
    Node root;

    static class Node {
        int data;
        int startInterval, endInterval;
        Node left, right;

        Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;

        }
    }

    SegmentTree(int[] arr) {
        this.root = buildTree(arr, 0, arr.length - 1);
    }

    public Node buildTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = buildTree(arr, start, mid);
        node.right = buildTree(arr, mid + 1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(root);
    }

    public void display(Node root) {
        if (root == null)
            return;
        String str = "";
        str = str + "Interval [" + root.startInterval + "-" + root.endInterval + "] | Data " + root.data;
        System.out.println(str);
        str += "\n";
        if (root.left != null)
            display(root.left);
        if (root.right != null)
            display(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.display();

    }

}
