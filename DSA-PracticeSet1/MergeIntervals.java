import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals) {
        // Sort intervals based on starting time using a comparator
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If merged list is empty or no overlap, add the interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Overlapping intervals; merge by updating the end time
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // Convert merged list to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the intervals in a single line (e.g., 1 3 2 4 6 8 9 10):");
        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");
        
        // Parse the input into a 2D array of intervals
        int[][] intervals = new int[inputArr.length / 2][2];
        for (int i = 0; i < inputArr.length; i += 2) {
            intervals[i / 2][0] = Integer.parseInt(inputArr[i]);
            intervals[i / 2][1] = Integer.parseInt(inputArr[i + 1]);
        }

        // Get merged intervals
        int[][] result = mergeIntervals(intervals);

        // Output the merged intervals
        System.out.println("Merged intervals: " + Arrays.deepToString(result));

        scanner.close();
    }
}
