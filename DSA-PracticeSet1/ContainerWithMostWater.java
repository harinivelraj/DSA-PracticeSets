import java.util.Scanner;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the current area
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);

            // Move the pointer for the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
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

        // Call the maxArea function and print the result
        System.out.println("Maximum area: " + maxArea(arr));
        
        // Close the scanner
        scanner.close();
    }
}
