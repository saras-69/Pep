public class AVL {
    Node root;

    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
            this.height = 1;
        }
    }

    AVL() {
        this.root = null;
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            return root.height;
        }
    }

    private int getBalance(Node root) {
        if (root == null)
            return 0;
        else
            return getHeight(root.left) - getHeight(root.right);
    }

    public Node leftRotate(Node x) {
        Node y = x.right, T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        return y;
    }

    public Node rightRotate(Node y) {
        Node x = y.left, T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        return x;
    }

    public void insert(int key) {
        root = insertData(root, key);
    }

    private Node insertData(Node root, int key) {
        if (root == null)
            return new Node(key);
        else if (key < root.data)
            root.left = insertData(root.left, key);
        else if (key > root.data)
            root.right = insertData(root.right, key);
        else
            return root; // Duplicate keys not allowed

        // Update height
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        // Get balance factor
        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && key < root.left.data)
            return rightRotate(root);

        // Right Right Case
        if (balance < -1 && key > root.right.data)
            return leftRotate(root);

        // Left Right Case
        if (balance > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public void inOrder() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        AVL avl = new AVL();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.inOrder();
    }
}