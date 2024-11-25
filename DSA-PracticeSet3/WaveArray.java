import java.util.Arrays;

public class WaveArray {
    public static void convertToWave(int[] arr, int n) {
        for (int i = 0; i < n - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length;

        convertToWave(arr, n);

        System.out.println("Wave Array: " + Arrays.toString(arr));
    }
}
