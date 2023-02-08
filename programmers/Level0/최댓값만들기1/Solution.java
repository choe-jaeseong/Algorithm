package Level0.최댓값만들기1;

import java.util.Arrays;

public class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length-1] * numbers[numbers.length-2];
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1, 2, 3};
        System.out.println(T.solution(arr));
    }
}
