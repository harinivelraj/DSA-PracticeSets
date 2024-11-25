class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BalancedTreeCheck {
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Helper method that returns the height of the tree if balanced, or -1 if unbalanced
    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        // Check if the current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Example tree: Balanced tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        if (isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}
