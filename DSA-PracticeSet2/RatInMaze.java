public class RatInMaze {
    // Dimensions of the maze
    private static final int N = 4;

    // Function to print the solution matrix
    private static void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Utility function to check if x, y is valid index for N*N maze
    private static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    // Solves the maze problem using backtracking
    private static boolean solveMaze(int[][] maze) {
        int[][] solution = new int[N][N]; // Initialize the solution matrix

        if (solveMazeUtil(maze, 0, 0, solution) == false) {
            System.out.println("Solution doesn't exist");
            return false;
        }
        
        printSolution(solution);
        return true;
    }

    // A recursive utility function to solve the Maze problem
    private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution) {
        // If (x, y) is the goal, return true
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            solution[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is a valid move
        if (isSafe(maze, x, y)) {
            // Mark x, y as part of the solution path
            solution[x][y] = 1;

            // Move forward in x direction
            if (solveMazeUtil(maze, x + 1, y, solution)) {
                return true;
            }

            // If moving in x doesn't work, move down in y direction
            if (solveMazeUtil(maze, x, y + 1, solution)) {
                return true;
            }

            // If none of the above movements work, backtrack and unmark x, y as part of solution path
            solution[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        solveMaze(maze);
    }
}
