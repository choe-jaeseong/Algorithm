package Level0.배열두배만들기;

public class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        for(int i=0; i<numbers.length; i++){
            numbers[i]=numbers[i]*2;
        }
        answer = numbers.clone();
        answer[0]=100;
        return answer;
    }
}
