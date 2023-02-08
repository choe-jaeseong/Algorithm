package Level0.최댓값만들기1;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length-1] * numbers[numbers.length-2];
    }

    //다른 풀이
    public int solution1(int[] numbers) {
        // reverse sort
        numbers = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int answer = numbers[0] * numbers[1];
        return answer;
    }
}
