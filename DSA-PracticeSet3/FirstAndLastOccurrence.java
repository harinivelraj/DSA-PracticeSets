public class FirstAndLastOccurrence {

    // Function to find the first occurrence of an element
    public static int firstOccurrence(int[] arr, int n, int x) {
        int low = 0, high = n - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid; // Update result and move to the left half
                high = mid - 1;
            } else if (arr[mid] > x) {
                high = mid - 1; // Move left
            } else {
                low = mid + 1; // Move right
            }
        }
        return result;
    }

    // Function to find the last occurrence of an element
    public static int lastOccurrence(int[] arr, int n, int x) {
        int low = 0, high = n - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid; // Update result and move to the right half
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1; // Move left
            } else {
                low = mid + 1; // Move right
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 6, 7, 8};
        int n = arr.length;
        int x = 4;

        int first = firstOccurrence(arr, n, x);
        int last = lastOccurrence(arr, n, x);

        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
    }
}
