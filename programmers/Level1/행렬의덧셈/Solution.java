package Level1.행렬의덧셈;

public class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int len1 = arr1.length;
        int len2 = arr1[0].length;
        int[][] answer = new int[len1][len2];
        /*
         *  int[][] answer = {};
            answer = arr1;       //arr1으로 할당해서 풀어도됨.(배열 크기는 같으니까)
         */
        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){
                answer[i][j]=arr1[i][j]+arr2[i][j];
            }
        }
        return answer;
    }
}
