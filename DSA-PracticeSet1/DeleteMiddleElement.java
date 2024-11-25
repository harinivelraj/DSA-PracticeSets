import java.util.Stack;

public class DeleteMiddleElement {
    public static void deleteMiddle(Stack<Integer> stack, int size, int currentIndex) {
        if (stack.isEmpty() || currentIndex == size) {
            return;
        }
        
        int middleIndex = size / 2;
        int temp = stack.pop();
        
        if (currentIndex == middleIndex) {
            return;
        }

        deleteMiddle(stack, size, currentIndex + 1);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int size = stack.size();
        deleteMiddle(stack, size, 0);
        
        // Print the stack after deletion
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
