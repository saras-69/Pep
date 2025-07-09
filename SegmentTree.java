import java.util.Scanner;

public class SegmentTree {
    Node root;

    static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left, right;

        Node(int startIndex, int endIndex) {
            this.startInterval = startIndex;
            this.endInterval = endIndex;
        }
    }

    SegmentTree(int[] arr) {
        this.root = buildTree(arr, 0, arr.length - 1);
    }

    // T(N) = O(N)
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

    // T(N) = O(log N)
    public int rangeQuery(int startInterval, int endInterval) {
        return rangeQuery(root, startInterval, endInterval);
    }

    public int rangeQuery(Node root, int sIdx, int eIdx) {
        if (root == null)
            return 0;
        else if (sIdx <= root.startInterval && eIdx >= root.endInterval)
            return root.data;
        else if (root.startInterval > eIdx || root.endInterval < sIdx)
            return 0;
        else
            return rangeQuery(root.left, sIdx, eIdx) + rangeQuery(root.right, sIdx, eIdx);
    }

    // T(N) =
    public int update(int idx, int elt) {
        return update(root, idx, elt);
    }

    public int update(Node node, int idx, int elt) {
        if (idx >= node.startInterval && idx <= node.endInterval) {
            if (idx == node.startInterval && idx == node.endInterval) {
                // update
                node.data = elt;
                return node.data;
            } else {
                // backtrack
                int leftSum = update(node.left, idx, elt);
                int rightSum = update(node.right, idx, elt);
                node.data = leftSum + rightSum;
                return node.data;
            }
        }
        return node.data;
    }

    // T(N) = O(N)
    public void display() {
        display(this.root);
    }

    public void display(Node root) {
        String str = "";
        str = str + "Interval - [" + root.startInterval + " - " + root.endInterval + "] | Data - " + root.data + " | ";
        System.out.println(str);
        if (root.left != null) {
            display(root.left);
        }
        if (root.right != null) {
            display(root.right);
        }
    }

    public static void main(String[] args) {
        /*
         * 8
         * 2 3 5 -6 12 1 4 9
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.display();
        System.out.println(segmentTree.rangeQuery(3, 6)); // 11
        segmentTree.update(3, -10);
        segmentTree.display();
        System.out.println(segmentTree.rangeQuery(3, 6)); // 7
    }
}
