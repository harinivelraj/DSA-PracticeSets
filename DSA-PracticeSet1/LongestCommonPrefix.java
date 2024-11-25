import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] arr) {
        if (arr.length == 0) return "-1";
        
        // Sort the array
        Arrays.sort(arr);
        
        // Compare the first and last string characters
        String first = arr[0];
        String last = arr[arr.length - 1];
        
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        
        String prefix = first.substring(0, i);
        return prefix.isEmpty() ? "-1" : prefix;
    }

    public static void main(String[] args) {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println(longestCommonPrefix(arr));
    }
}
