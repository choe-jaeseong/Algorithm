package Level0.컨트롤제트;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        int answer = 0, tmp = 0;
        String[] arr = s.split(" ");
        for(String x : arr){
            if(!x.equals("Z")){
                answer += Integer.parseInt(x);
                tmp = Integer.parseInt(x);
            } else {
                answer -= tmp;
            }
        }
        return answer;
    }

    //다른 풀이1
    public int solution1(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (String w : s.split(" ")) {
            if (w.equals("Z")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(w));
            }
        }
        for (int i : stack) {
            answer += i;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("10 20 30 Z"));
    }
}
