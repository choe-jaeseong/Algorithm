import java.util.*;

class Solution {
    private static int[] dx = {0,0,1,-1,1,1,-1,-1};
    private static int[] dy = {1,-1,0,0,1,-1,1,-1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        for(int[] r : rectangle) {
            for(int i=r[0]*2; i<=r[2]*2; i++) {
                for(int j=r[1]*2; j<=r[3]*2; j++) {
                    if(map[i][j] == 1) continue;
                    map[i][j] = 1;
                    if(i == r[0]*2 || i == r[2]*2 || j == r[1]*2 || j == r[3]*2) 
                        map[i][j] = 2;
                }
            }
        }
        
        //탐색
        Queue<Coor> q = new LinkedList<>();
        q.add(new Coor(characterX*2, characterY*2, 0));
        boolean[][] isVisited = new boolean[101][101];
        isVisited[characterX*2][characterY*2] = true;
        while(!q.isEmpty()) {
            Coor c = q.poll();
            if(c.x == itemX*2 && c.y == itemY*2) return c.d / 2;
            
            for(int i=0; i<4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if(!(nx>=2 && nx<=100 && ny>=2 && ny<=100)) continue;
                if(isVisited[nx][ny]) continue;
                if(map[nx][ny] == 2) {
                    isVisited[c.x][c.y] = true;
                    q.add(new Coor(nx, ny, c.d + 1));
                }
            }
        }
        return 0;
    }
    
    class Coor {
        int x;
        int y;
        int d;
        Coor(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
/*
1. 각 직사각형을 지도에 그리기
2. 시작점부터 타겟까지 BFS
    - 가에를 도는지 확인하는 방법 : 주변에 0 이 있는지.
    - 가장 짧은 거리 리턴.

*/