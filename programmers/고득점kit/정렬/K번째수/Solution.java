package 고득점kit.정렬.K번째수;

//level1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] arr = new int[commands[i][1]-commands[i][0]+1];
            for(int j=commands[i][0]; j<=commands[i][1]; j++){
                arr[j-commands[i][0]]=array[j-1];
            }
            Arrays.sort(arr);
            answer[i]=arr[commands[i][2]-1];
        }
        return answer;
    }

    //예전 풀이
    public int[] solution1(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=commands[i][0]-1; j<=commands[i][1]-1; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i]=list.get(commands[i][2]-1);
        }
        return answer;
    }

    //다른 분 풀이
    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
