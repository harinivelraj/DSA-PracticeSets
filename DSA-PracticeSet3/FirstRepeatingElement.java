import java.util.HashSet;

public class FirstRepeatingElement {
    public static int findFirstRepeating(int[] arr, int n) {
        HashSet<Integer> seen = new HashSet<>();
        int firstRepeating = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (seen.contains(arr[i])) {
                firstRepeating = arr[i];
            } else {
                seen.add(arr[i]);
            }
        }
        return firstRepeating;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 1};
        int n = arr.length;
        int result = findFirstRepeating(arr, n);
        if (result != -1) {
            System.out.println("First Repeating Element: " + result);
        } else {
            System.out.println("No Repeating Elements Found");
        }
    }
}
