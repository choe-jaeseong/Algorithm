import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        // answer 배열의 모든 값을 -1로 채움
        Arrays.fill(answer, -1);
        
        // stack 생성
        Stack<Integer> stack = new Stack<>();
        
        // 맨 뒤에 있는 값부터 배열의 길이만큼 반복
        for(int i = numbers.length - 1; i >= 0; i--) {
        	// stack이 비어있지 않으면서
            // stack 맨 위의 값이 numbers[i]보다 작거나 같다면
            while(!stack.isEmpty() && numbers[i] >= stack.peek()) {
            	// stack에서 값을 제거
                stack.pop();
            }
            
            // 만약 stack이 비어있지 않다면
            if(!stack.isEmpty()) {
            	// 가장 위에 있는 값을 저장
                answer[i] = stack.peek();
            }
            
            // stack에 값을 넣어줌
            stack.push(numbers[i]);
        }
        
        return answer;
    }
}