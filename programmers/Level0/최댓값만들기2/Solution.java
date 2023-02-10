package Level0.최댓값만들기2;

import java.util.Arrays;

public class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int res1 = numbers[0]*numbers[1];
        int res2 = numbers[numbers.length-1]*numbers[numbers.length-2];
        return res1>res2? res1: res2;
    }

    //다른 풀이1
    public int solution1(int[] numbers) {
        int len = numbers.length;
        Arrays.sort(numbers);
        return Math.max(numbers[0] * numbers[1], numbers[len - 2] * numbers[len - 1]);
    }
}
