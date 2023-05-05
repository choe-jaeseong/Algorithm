package Book.정렬.K번째수;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands){
        int[] answer = new int[commands.length];

        for(int i = 0 ; i < answer.length; i++){
            int[] command = commands[i];
            int from = command[0];
            int to = command[1];
            int k = command[2];
            
            int[] sub = Arrays.copyOfRange(array, from, to);
            Arrays.sort(sub);
            answer[i] = sub[k];
        }
        return answer;
    }
}
