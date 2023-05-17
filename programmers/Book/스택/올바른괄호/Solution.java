package 스택.올바른괄호;

import java.util.Stack;

public class Solution {

    //강의 답
    public boolean solution1(String s){
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            switch (c) {
                case '(' -> stack.push(c);
                case ')' -> {
                    if(stack.isEmpty()) return false;
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    //나의 답
    public boolean solution(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }
}
