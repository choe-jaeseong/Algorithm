package Level2.짝지어제거하기;

import java.util.Stack;

/* =>>>>> 시간 초과
 * 1. 문자열 길이를 저장
 * 2. removeDouble을 거친다. (중복 제거)
 * 3. 문자열 길이가 0이면 return 1
 * 4. 문자열 길이가 변함이 없다면 return 0
 * 5. 문자열 길이가 감소했다면 다시 2번 과정.
 */

/* Stack 활용
 * 1. 첫번째 문자 push
 * 2. 문자열 회문
 * 3. peek() 문자와 같다면, pop()
 * 4. 다르다면 push()
 * 5. 반복문 종료 이후, 최종 stack 에 남아있으면, return 0;
 * 6. 없으면 return 1.
 */

public class Solution {
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(stack.isEmpty())
                stack.push(s.charAt(i));
            else if(stack.peek() == s.charAt(i)) 
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        return stack.isEmpty() ? 1 : 0;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("baabaa"));
    }
}
