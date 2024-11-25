public class MaxOnesRow {
    public static int rowWithMaxOnes(int[][] matrix) {
        int maxRow = -1;
        int maxCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            int count = countOnes(matrix[i]);
            if (count > maxCount) {
                maxCount = count;
                maxRow = i;
            }
        }

        return maxRow;
    }

    private static int countOnes(int[] row) {
        int left = 0;
        int right = row.length - 1;

        // Binary search for the first 1 in the row
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1 && (mid == 0 || row[mid - 1] == 0)) {
                return row.length - mid; // Number of 1s in the row
            } else if (row[mid] == 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0; // No 1s in the row
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 0, 1},
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };
        int maxRow = rowWithMaxOnes(matrix);
        System.out.println("Row with max 1s: " + maxRow);
    }
}
