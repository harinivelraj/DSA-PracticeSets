class BinaryTree2 {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {
        BinaryTree2 tree = new BinaryTree2();

        tree.root = new BinaryTree2.Node(12); // Correct reference to the Node class inside BinaryTree2
        tree.root.left = new BinaryTree2.Node(8);
        tree.root.right = new BinaryTree2.Node(18);
        tree.root.left.left = new BinaryTree2.Node(5);
        tree.root.left.right = new BinaryTree2.Node(11);

        System.out.println("Maximum depth of the binary tree is: " + tree.maxDepth(tree.root));
    }
}
