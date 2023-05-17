package DP.등굣길;

import java.util.Arrays;

public class Solution {
    private final int[][] mem = new int[101][101];

    public int count(int x, int y, int h, int w, boolean[][] isPuddle){
        if(x > h || y > w) return 0;
        if(isPuddle[x][y]) return 0;

        if(mem[x][y] != -1) return mem[x][y];
        if(x == h && y == w) return 1;

        int total = count(x+1, y, h, w, isPuddle)
                    + count(x, y+1, h, w, isPuddle);
        return mem[x][y] = total % 1000000007;
    }

    public int solution(int m, int n, int[][] puddles){
        for(int[] row : mem){
            Arrays.fill(row, -1);
        }
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for(int[] p : puddles){
            isPuddle[p[1]][p[0]] = true;
        }

        return count(1, 1, n, m, isPuddle);
    }
}
