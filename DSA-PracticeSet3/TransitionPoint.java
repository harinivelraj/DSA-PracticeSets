public class TransitionPoint {
    public static int findTransitionPoint(int[] arr, int n) {
        int low = 0, high = n - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1, 1, 1};
        int n = arr.length;
        System.out.println("Transition Point: " + findTransitionPoint(arr, n));
    }
}
