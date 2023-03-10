package Level1.평균구하기;

import java.util.Arrays;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int x : arr){
            answer += x;
        }
        return answer / arr.length;
    }

    //다른 풀이1
    public double solution1(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}