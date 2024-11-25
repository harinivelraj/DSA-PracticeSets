import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class BinaryTreeToBSTConverter {
    public void convertToBST(TreeNode root) {
        if (root == null) return;

        // Step 1: Collect all node values using in-order traversal
        List<Integer> values = new ArrayList<>();
        collectValues(root, values);

        // Step 2: Sort the collected values
        Collections.sort(values);

        // Step 3: Replace the values in the tree using in-order traversal
        int[] index = {0}; // Mutable index for replacing values
        replaceValues(root, values, index);
    }

    private void collectValues(TreeNode node, List<Integer> values) {
        if (node == null) return;

        collectValues(node.left, values);
        values.add(node.val);
        collectValues(node.right, values);
    }

    private void replaceValues(TreeNode node, List<Integer> values, int[] index) {
        if (node == null) return;

        replaceValues(node.left, values, index);
        node.val = values.get(index[0]++);
        replaceValues(node.right, values, index);
    }
}

public class BinaryTreeToBSTConverterMain {
    public static void main(String[] args) {
        // Constructing a binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(30);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.right.right = new TreeNode(5);

        System.out.println("Original Tree (In-Order Traversal):");
        printInOrder(root);

        // Convert to BST
        BinaryTreeToBSTConverter converter = new BinaryTreeToBSTConverter();
        converter.convertToBST(root);

        System.out.println("\nConverted BST (In-Order Traversal):");
        printInOrder(root);
    }

    // Helper method to print tree in in-order traversal
    private static void printInOrder(TreeNode node) {
        if (node == null) return;

        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
}
