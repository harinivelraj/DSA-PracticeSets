import java.util.*;

public class SnakesAndLadders {

    // Step 2: Function to simulate the game with BFS
    public static boolean bfs(Map<Integer, Integer> board, int[] rolls, int target) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        queue.add(1);  // Start at position 1
        visited[1] = true;

        for (int roll : rolls) {
            Queue<Integer> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int position = queue.poll();
                int newPosition = position + roll;
                if (newPosition > 100) newPosition = 100; // Cap at 100
                int finalPosition = board.get(newPosition);

                // Debug: Print the current state after applying a roll
                System.out.println("Current Position: " + position + ", Roll: " + roll + ", New Position: " + newPosition + ", Final Position: " + finalPosition);

                if (finalPosition == target) {
                    return true; // Reached target
                }
                if (!visited[finalPosition]) {
                    visited[finalPosition] = true;
                    nextQueue.add(finalPosition);
                }
            }
            queue = nextQueue;
        }

        return false; // Target not reachable
    }

    public static String detectFaultySnakeOrLadder(int[][] connections, int[] diceRolls, int target) {
        // Step 1: Create the board mapping
        Map<Integer, Integer> board = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            board.put(i, i); // Initially, every cell maps to itself
        }
        for (int[] connection : connections) {
            board.put(connection[0], connection[1]);
        }

        // Step 3: Simulate the game with the original board
        if (bfs(board, diceRolls, target)) {
            return "Not affected";
        }

        // Step 4: Test switching each snake/ladder
        for (int[] connection : connections) {
            int start = connection[0], end = connection[1];
            Map<Integer, Integer> modifiedBoard = new HashMap<>(board);

            // Neutralize the ladder or snake
            if (start < end) {
                modifiedBoard.put(start, start); // Neutralize ladder
            } else {
                modifiedBoard.put(start, end); // Neutralize snake
            }

            // Debug: Print the board after modification
            System.out.println("Modified Board: " + modifiedBoard);

            // Simulate the game again with the modified board
            if (bfs(modifiedBoard, diceRolls, target)) {
                return start < end ? "Ladder " + start + " " + end : "Snake " + start + " " + end;
            }
        }

        // Step 5: If no switch works, the target is not reachable
        return "Not reachable";
    }

    public static void main(String[] args) {
        // New connections
        int[][] connections = {
            {16, 9}, {38, 6}, {45, 68}, {63, 23}, {75, 99}, {79, 22}, {98, 2}
        };
        int[] diceRolls = {3, 2, 5, 3, 4, 4, 1, 2, 3}; // Rolls of the dice
        int target = 85;

        String result = detectFaultySnakeOrLadder(connections, diceRolls, target);
        System.out.println("Result: " + result);  // Expected to print "Ladder 22 79"
    }
}
