package Level0.겹치는선분의길이;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] arr = new int[201];
        for(int[] x : lines){
            for(int i=x[0]+100; i<x[1]+100; i++) {
                arr[i]++;
            }
        }
        for(int i=0; i<201; i++){
            if(arr[i]>1) answer++;
        }
        return answer;
    }
    //다른 풀이1
    public int solution1(int[][] lines) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] line : lines) {
            int from = Math.min(line[0], line[1]);
            int to = Math.max(line[0], line[1]);
            for (int i = from; i < to; i++) {
                map.merge(i, 1, Integer::sum);
            }
        }

        return (int) map.values().stream().filter(i -> i > 1).count();
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr = {{0, 5}, {3, 9},{1, 10}};
        System.out.println(T.solution(arr));
    }
}
