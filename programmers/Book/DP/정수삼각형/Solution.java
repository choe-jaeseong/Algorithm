package DP.정수삼각형;

import java.util.Arrays;

public class Solution {
    private final int[][] mem = new int[501][501];

    private int max(int x, int y, int[][] triangle){
        if(x == triangle.length) return 0;
        if(mem[x][y] != -1) return mem[x][y];

        return mem[x][y] = triangle[x][y] + Math.max(
            max(x+1, y, triangle),
            max(x+1, y+1, triangle));
    }

    public int solution(int[][] triangle){
        for(int[] row : mem){
            Arrays.fill(row, -1);
        }
        return max(0,0, triangle);
    }


    
    public static void main(String[] args){
        Solution T = new Solution();
        int[][] triangle = {
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5}
        };
        System.out.println(T.solution(triangle));
    }
}
