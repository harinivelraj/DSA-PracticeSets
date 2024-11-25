import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class BinaryTreeViews {
    // Top View
    public List<Integer> topView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            TreeNode node = curr.node;
            int hd = curr.hd;

            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.val); // First node at horizontal distance
            }

            if (node.left != null) queue.add(new Pair(node.left, hd - 1));
            if (node.right != null) queue.add(new Pair(node.right, hd + 1));
        }

        return new ArrayList<>(topViewMap.values());
    }

    // Bottom View
    public List<Integer> bottomView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, Integer> bottomViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            TreeNode node = curr.node;
            int hd = curr.hd;

            bottomViewMap.put(hd, node.val); // Overwrite the node at horizontal distance

            if (node.left != null) queue.add(new Pair(node.left, hd - 1));
            if (node.right != null) queue.add(new Pair(node.right, hd + 1));
        }

        return new ArrayList<>(bottomViewMap.values());
    }

    // Left View
    public List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftViewHelper(root, 0, result);
        return result;
    }

    private void leftViewHelper(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;

        if (result.size() == level) {
            result.add(node.val); // First node at each level
        }

        leftViewHelper(node.left, level + 1, result);
        leftViewHelper(node.right, level + 1, result);
    }

    // Right View
    public List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightViewHelper(root, 0, result);
        return result;
    }

    private void rightViewHelper(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;

        if (result.size() == level) {
            result.add(node.val); // First node at each level
        }

        rightViewHelper(node.right, level + 1, result);
        rightViewHelper(node.left, level + 1, result);
    }

    // Helper class for top/bottom views
    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}

public class BinaryTreeMain {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BinaryTreeViews views = new BinaryTreeViews();

        System.out.println("Top View: " + views.topView(root));
        System.out.println("Bottom View: " + views.bottomView(root));
        System.out.println("Left View: " + views.leftView(root));
        System.out.println("Right View: " + views.rightView(root));
    }
}
