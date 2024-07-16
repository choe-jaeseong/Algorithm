import java.util.*;

class Solution {
    private static final int[][] mem = new int[501][501];
    private static int max(int x, int y, int[][] triangle) {
        if(x == triangle.length) return 0;
        if(mem[x][y] != -1) return mem[x][y];
        
        return mem[x][y] = triangle[x][y] + Math.max(
            max(x + 1, y, triangle),
            max(x + 1, y + 1, triangle));
    }
    
    public int solution(int[][] triangle) {
        for(int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return max(0, 0, triangle);
    }
}

/*
풀이 2. DP
상태 : (x,y) -> x, y 위치에서 출발했을 때, 거쳐가는 숫자의 합의 최댓값
종료조건 : (x,H) -> 0
점화식 : (x,y) -> [x,y] + MAX[(x+1, y), (x+1, y+1)]

풀이 1. 완전탐색

class Solution {
    private static int answer = 0;
    public int solution(int[][] triangle) {
        DFS(triangle[0][0], 0, 0, triangle);
        return answer;
    }
    
    private static void DFS(int sum, int x, int y, int[][] triangle) {
        if(x == triangle.length - 1) {
            answer = Math.max(answer, sum);
            return;
        }
        
        DFS(sum + triangle[x + 1][y], x + 1, y, triangle);
        DFS(sum + triangle[x + 1][y + 1], x + 1, y + 1, triangle);
    }
}

*/