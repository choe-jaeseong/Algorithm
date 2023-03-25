package Stack;

import java.util.Stack;

class practice{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        System.out.println(stack.peek());
        stack.pop();
        // System.out.println(stack.peek());
    }
}