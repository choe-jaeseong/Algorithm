package 스택.괄호회전하기;

import java.util.Stack;

public class Solution {
    
    //강의 답
    private boolean isCorrect(char[] str, int offset){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < str.length; i++){
            char c = str[(offset + i) % str.length];
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                case ')','}',']' -> {
                    if(stack.isEmpty()) return false;
                    if(stack.pop() != c) return false;
                }
            }
        }

        return stack.isEmpty();
    }
    
    public int solution1(String s) {
        char[] str = s.toCharArray();

        int count = 0;
        for(int offset = 0; offset < s.length(); offset++){
            if(isCorrect(str, offset)){
                count++;
            }
        }
        return count;
    }


    //나의 답
    private boolean isRight(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                switch (c) {
                    case ')' -> {
                        if(stack.peek() == '(') stack.pop();
                        else return false;
                    }
                    case '}' -> {
                        if(stack.peek() == '{') stack.pop();
                        else return false;
                    }
                    case ']' -> {
                        if(stack.peek() == '[') stack.pop();
                        else return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public int solution(String s) {
        int count = 0;
        for(int x = 0; x < s.length(); x++){
            String tmp = s.substring(x) + s.substring(0, x);
            if(isRight(tmp)) count++;
        }
        return count;
    }
}
