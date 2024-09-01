import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for(int i=1; i<=order.length; i++) {
            if(order[idx] == i) {
                answer++;
                idx++;
            } else if (!stack.isEmpty() && order[idx] == stack.peek()){
                answer++;
                stack.pop();
                idx++;
                i--;
            } else {
                stack.add(i);
            }
        }
        while(idx < order.length 
              && !stack.isEmpty() 
              && order[idx] == stack.peek()) {
            answer++;
            stack.pop();
            idx++;
        }
        return answer;
    }
}