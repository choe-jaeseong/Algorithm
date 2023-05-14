package 정렬.K번째수;

import java.util.Arrays;

/*
 * 0. 정답 반환할 배열 생성.
 * 1. commands 에서 command 배열 생성
 * 2. from to k 변수를 추출
 * 3. array 에서 copyOfRange from to
 * 4. 정렬
 * 5. k 값 입력
 */
public class Solution1 {
    public int[] solution(int[] array, int[][] commands){
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
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
