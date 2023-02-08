package Level0.중복된숫자개수;

import java.util.Arrays;

public class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        for (int num : array) {
            if (num == n) answer++;
        }
        return answer;
    }

    //다른 풀이
    public int solution1(int[] array, int n) {
        return (int) Arrays.stream(array).filter(i -> i == n).count();
    }

    //다른 풀이
    public int solution2(int[] array, int n) {
        return (int) Arrays.stream(array)
                .filter(e -> e == n)
                .count();
    }
}
