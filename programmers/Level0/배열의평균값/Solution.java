package Level0.배열의평균값;

import java.util.Arrays;

public class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        for(int i=0; i<numbers.length; i++){
            answer += numbers[i];
        }
        answer /= numbers.length;
        return answer;
    }

    //다른 사람 풀이
    public double solution2(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0);
    }
}
