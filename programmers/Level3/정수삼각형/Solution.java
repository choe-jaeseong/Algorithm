package Level3.정수삼각형;

import java.util.Arrays;

class Solution {

    //다른 풀이1(dp)
    public int solution1(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++) 
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
    //시간 초과
    static int answer = 0;
    static int[][] arr;
    public void DFS(int L, int i, int sum){
        if(L==arr.length){
            answer = answer>sum ? answer : sum;
            return ;
        }
        DFS(L+1, i, sum+arr[L][i]);
        DFS(L+1, i+1, sum+arr[L][i+1]);
    }
    public int solution(int[][] triangle) {
        arr = triangle;
        DFS(1,0,triangle[0][0]);
        return answer;
    }
}
