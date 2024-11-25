import java.util.Scanner;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        // Arrays to store the maximum heights to the left and right of each element
        int[] left_max = new int[n];
        int[] right_max = new int[n];

        // Fill left_max array
        left_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }

        // Fill right_max array
        right_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }

        // Calculate the total water trapped
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(left_max[i], right_max[i]) - height[i];
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] arr = new int[n];

        // Get the array elements from the user
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the trap function and print the result
        System.out.println("Water trapped: " + trap(arr));

        // Close the scanner
        scanner.close();
    }
}
