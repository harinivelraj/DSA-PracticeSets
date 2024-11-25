import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    public void printRightView(Node node) {
        if (node == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int levelNodeCount = queue.size();

            for (int i = 1; i <= levelNodeCount; i++) {
                Node tempNode = queue.poll();

                if (i == levelNodeCount) {
                    System.out.print(tempNode.data + " ");
                }

                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4); 
        tree.root.right.right = new Node(5); 

        System.out.println("Right view of the binary tree is:");
        tree.printRightView(tree.root);
    }
}
