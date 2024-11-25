import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static int findLongestConsecutiveSubsequence(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int longestStreak = 0;

        // Add all elements to the set
        for (int num : nums) {
            set.add(num);
        }

        // Find the longest consecutive sequence
        for (int num : nums) {
            // Only start sequence if `num - 1` is not in the set
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = findLongestConsecutiveSubsequence(nums);
        System.out.println("Length of the longest consecutive subsequence: " + result);
    }
}
