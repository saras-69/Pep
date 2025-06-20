public class AVLDELETION {
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

    AVLDELETION() {
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
        if (key < root.data)
            root.left = insertData(root.left, key);
        else if (key > root.data)
            root.right = insertData(root.right, key);
        else
            return root; // Duplicate keys not allowed

        // Update height
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        // Balance the tree
        return balanceNode(root, key);
    }

    private Node balanceNode(Node root, int key) {
        // Get balance factor
        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Find the node with minimum value in BST
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Delete a node from AVL tree
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node root, int key) {
        // Standard BST delete
        if (root == null)
            return root;

        // If key is smaller, it lies in left subtree
        if (key < root.data)
            root.left = deleteNode(root.left, key);

        // If key is larger, it lies in right subtree
        else if (key > root.data)
            root.right = deleteNode(root.right, key);

        // If key is same as root's key, this is the node to be deleted
        else {
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of the non-empty child
            } else {
                // Node with two children: Get the inorder successor (smallest
                // in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.data = temp.data;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // UPDATE HEIGHT OF THE CURRENT NODE
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        // GET THE BALANCE FACTOR AND BALANCE THE TREE
        return balanceNode(root, key);
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
        AVLDELETION avl = new AVLDELETION();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);

        avl.inOrder();

        avl.delete(30);
        avl.inOrder();
    }
}
