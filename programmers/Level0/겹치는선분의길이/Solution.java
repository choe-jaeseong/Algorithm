package Level0.겹치는선분의길이;

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
            if(arr[i]>=2 && arr[i+1]>=2) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr = {{0, 5}, {3, 9},{1, 10}};
        System.out.println(T.solution(arr));
    }
}
