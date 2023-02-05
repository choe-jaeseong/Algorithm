package Level0.짝수홀수개수;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for(int i=0; i<num_list.length; i++){
            if(num_list[i]%2==0) answer[0]++;
            else answer[1]++;
        }
        return answer;
    }

    //다른 사람 풀이
    public int[] solution2(int[] num_list) {
        int[] answer = new int[2];

        for(int i = 0; i < num_list.length; i++)
            answer[num_list[i] % 2]++;

        return answer;
    }

    //다른 사람 풀이
    public int[] solution3(int[] numList) {
        return IntStream.of((int) Arrays.stream(numList).filter(i -> i % 2 == 0).count(), (int) Arrays.stream(numList).filter(i -> i % 2 == 1).count()).toArray();
    }
}
