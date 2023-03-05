package Level1.과일장수;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        // Arrays.sort(score, Collections.reverseOrder()); //int[] 배열 내림차순 메서드가 없음
        Integer[] arr_integer = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(arr_integer, Collections.reverseOrder());
        Integer min1 = 10;
        for(int i = 0; i<arr_integer.length; i++){
            if(min1>arr_integer[i]) min1 = arr_integer[i];
            if(i%m==m-1) answer += min1 * m;
            System.out.println("i: "+i+", min1: "+min1+", answer: "+answer);
        }
        return answer;
    }
    //다른 풀이1
    public int solution1(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println(T.solution(4,3,arr));
    }

}