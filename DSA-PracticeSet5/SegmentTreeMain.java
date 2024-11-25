class SegmentTree {
    private int[] tree;   // Segment Tree array
    private int[] nums;   // Original array
    private int n;        // Size of the array

    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[4 * n]; // Allocate enough space
        build(0, 0, n - 1);         // Build the tree
    }

    // Build the segment tree
    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start]; // Leaf node
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            build(leftChild, start, mid);      // Build left subtree
            build(rightChild, mid + 1, end);  // Build right subtree

            tree[node] = tree[leftChild] + tree[rightChild]; // Merge results
        }
    }

    // Update a value at index `idx` in the array to `val`
    public void update(int idx, int val) {
        update(0, 0, n - 1, idx, val);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            nums[idx] = val;    // Update the value in the array
            tree[node] = val;   // Update the tree
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            if (idx <= mid) {
                update(leftChild, start, mid, idx, val); // Update left subtree
            } else {
                update(rightChild, mid + 1, end, idx, val); // Update right subtree
            }

            tree[node] = tree[leftChild] + tree[rightChild]; // Merge results
        }
    }

    // Query the sum in the range [L, R]
    public int query(int L, int R) {
        return query(0, 0, n - 1, L, R);
    }

    private int query(int node, int start, int end, int L, int R) {
        if (R < start || L > end) {
            return 0; // Out of range
        }

        if (L <= start && end <= R) {
            return tree[node]; // Fully within range
        }

        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        int leftSum = query(leftChild, start, mid, L, R);       // Query left subtree
        int rightSum = query(rightChild, mid + 1, end, L, R);  // Query right subtree

        return leftSum + rightSum; // Combine results
    }

    // Display the Segment Tree
    public void display() {
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }
}

public class SegmentTreeMain {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};

        SegmentTree segmentTree = new SegmentTree(nums);

        System.out.println("Original Segment Tree:");
        segmentTree.display();

        // Query the sum of range [1, 3]
        System.out.println("Sum of range [1, 3]: " + segmentTree.query(1, 3)); // Output: 15

        // Update the value at index 1 to 10
        segmentTree.update(1, 10);
        System.out.println("After updating index 1 to 10:");

        // Query the sum of range [1, 3] again
        System.out.println("Sum of range [1, 3]: " + segmentTree.query(1, 3)); // Output: 22
    }
}
