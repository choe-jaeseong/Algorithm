import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.add(c);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        if(stack.isEmpty()) return true;
        else return false;
    }
}

/*
해결방식 1. 스택 이용하기
해결방식 2. 숫자로 구현하기
*/