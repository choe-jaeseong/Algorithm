import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = s;
        for(int i=0; i<s.length(); i++) {
            str = s.substring(i) + s.substring(0, i);
            if(isCorrect(str)) answer++;
        }
        return answer;
    }
    
    private static boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            switch(c) {
                case '(', '[', '{' -> stack.add(c);
                default -> {
                    if(stack.isEmpty()) return false;
                    if(c == ')') {
                        if(stack.pop() != '(') return false;
                    } else if(c == ']') {
                        if(stack.pop() != '[') return false;
                    } else if(c == '}') {
                        if(stack.pop() != '{') return false;
                    }
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}