class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class BinarySearchTreeValidator {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode node, long minimum, long maximum) {
        if (node == null) return true;

        if (!(node.val > minimum && node.val < maximum)) return false;

        return valid(node.left, minimum, node.val) && valid(node.right, node.val, maximum);
    }
}

public class BinarySearchTreeValidatorMain {
    public static void main(String[] args) {
        // Constructing the binary tree
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // Test the isValidBST method
        BinarySearchTreeValidator validator = new BinarySearchTreeValidator();
        boolean result = validator.isValidBST(root);

        System.out.println("Is the binary tree a valid BST? " + result);

        // Example of an invalid BST
        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(1);
        invalidRoot.right = new TreeNode(4);
        invalidRoot.right.left = new TreeNode(3);
        invalidRoot.right.right = new TreeNode(6);

        boolean invalidResult = validator.isValidBST(invalidRoot);
        System.out.println("Is the binary tree a valid BST? " + invalidResult);
    }
}
