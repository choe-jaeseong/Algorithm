package Level1.없는숫자더하기;

public class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        for(int x : numbers){
            answer -= x;
        }
        return answer;
    }
}
