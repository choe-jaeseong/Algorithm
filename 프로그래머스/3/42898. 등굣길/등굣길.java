import java.util.*;

class Solution {
    private static int[][] mem = new int[101][101];
    public int solution(int m, int n, int[][] puddles) {
        for(int[] row : mem) {
            Arrays.fill(row, -1);
        }
        
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for(int[] p : puddles) {
            isPuddle[p[1]][p[0]] = true;
        }
        return count(1, 1, n, m, isPuddle);
    }
    
    private static int count(int x, int y, int h, int w, boolean[][] isPuddle) {
        if(x > h || y > w) return 0;
        if(isPuddle[x][y]) return 0;
        
        if(mem[x][y] != -1) return mem[x][y];
        if(x == h && y == w) return 1;
        
        int total = count(x + 1, y, h, w, isPuddle)
                    + count(x, y + 1, h, w, isPuddle);
        return mem[x][y] = total % 1_000_000_007;
    }
}

/*
상태 : (x,y) | 격자의 (x,y)에서 출발하여 학교까지 가는 최단 경로의 수 
종료조건 : 
    - [x,y] 웅덩이 = 0
    - (m+1,n) = (m, n+1) = 0
    - (m, n) = 1 도착했을 때
점화식 : 
    (x,y) = (x+1,y) + (x,y+1)
*/