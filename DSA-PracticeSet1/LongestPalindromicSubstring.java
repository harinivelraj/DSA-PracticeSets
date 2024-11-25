public class LongestPalindromicSubstring {
    public static String longestPalindrome(String str) {
        int n = str.length();
        if (n == 0) return "";
        
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;

                if (str.charAt(i) == str.charAt(j)) {
                    if (length == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && length > maxLength) {
                    start = i;
                    maxLength = length;
                }
            }
        }

        return str.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println(longestPalindrome(str));
    }
}
