package 고득점kit.스택_큐.올바른괄호;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(char x : s.toCharArray()){
            if(x=='(') stack.add(x);
            else if(x==')'){
                if(stack.isEmpty()) return false;
                else if(stack.peek()=='(') stack.pop();
                else return false;
            }
        }
        if(stack.size()>0) return false;
        return answer;
    }

    //다른 나의 풀이1
    boolean solution1(String s) {
        boolean answer = true;
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(cnt==0){
                if(c==')') return false;
                else cnt++;
            } else {
                if(c==')') cnt--;
                else cnt++;
            }
        }
        if(cnt!=0) return false;
        return answer;
    }
}
