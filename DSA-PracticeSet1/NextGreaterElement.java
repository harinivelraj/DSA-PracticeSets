import java.util.Stack;

public class NextGreaterElement {
    public static void nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int index = stack.pop();
                System.out.println(arr[index] + " --> " + arr[i]);
            }
            stack.push(i);
        }
        
        // For elements with no next greater element
        while (!stack.isEmpty()) {
            int index = stack.pop();
            System.out.println(arr[index] + " --> -1");
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        nextGreaterElement(arr);
    }
}
