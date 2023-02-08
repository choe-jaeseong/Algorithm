package Level0.머쓱이보다키큰사람;

import java.util.Arrays;

public class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for(int i: array){
            answer += (i>height) ? 1 : 0;
        }
        return answer;
    }

    //다른 풀이
    public int solution1(int[] array, int height) {
        return (int) Arrays.stream(array).filter(value -> value > height).count();
    }
}
