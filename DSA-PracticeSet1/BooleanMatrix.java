public class BooleanMatrix {
    public static void modifyMatrix(int mat[][]) {
        int M = mat.length, N = mat[0].length;
        boolean[] row = new boolean[M];
        boolean[] col = new boolean[N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 1) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (row[i] || col[j]) {
                    mat[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int mat1[][] = {{1, 0}, {0, 0}};
        modifyMatrix(mat1);
        printMatrix(mat1);

        int mat2[][] = {{0, 0, 0}, {0, 0, 1}};
        modifyMatrix(mat2);
        printMatrix(mat2);

        int mat3[][] = {{1, 0, 0, 1}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        modifyMatrix(mat3);
        printMatrix(mat3);
    }

    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
