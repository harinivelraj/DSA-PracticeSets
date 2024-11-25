public class ParenthesesBalance {
    public static String checkBalance(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == ')') {
                count--;
            }

            if (count < 0) {
                return "Not Balanced";
            }
        }

        return count == 0 ? "Balanced" : "Not Balanced";
    }

    public static void main(String[] args) {
        String str1 = "((()))()()";
        System.out.println(checkBalance(str1));

        String str2 = "())((())";
        System.out.println(checkBalance(str2));
    }
}
