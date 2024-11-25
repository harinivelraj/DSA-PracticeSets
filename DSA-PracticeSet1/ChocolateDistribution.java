import java.util.Arrays;
import java.util.Scanner;

public class ChocolateDistribution {

    public static int findMinDifference(int[] arr, int n, int m) {
        // If there are no chocolates or students
        if (m == 0 || n == 0) {
            return 0;
        }

        // Sort the array
        Arrays.sort(arr);

        // If there are fewer packets than students, we cannot distribute
        if (n < m) {
            return -1; // Not enough packets for each student
        }

        // Initialize minimum difference as a large number
        int minDiff = Integer.MAX_VALUE;

        // Find the minimum difference by comparing consecutive sets of m packets
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = arr[i + m - 1] - arr[i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the array of chocolates in a single line
        System.out.print("Enter the packets of chocolates separated by space: ");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Read the number of students (m)
        System.out.print("Enter the number of students: ");
        int m = scanner.nextInt();

        // Calculate and display the minimum difference
        int result = findMinDifference(arr, arr.length, m);
        if (result == -1) {
            System.out.println("Not enough packets for each student.");
        } else {
            System.out.println("Minimum difference is " + result);
        }
        
        scanner.close();
    }
}
