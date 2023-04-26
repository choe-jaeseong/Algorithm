package 고득점kit.DFS_BFS.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

class GPS{
    int x, y;
    GPS(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    int[] dx = {0,0,1,-1}; //동서남북
    int[] dy = {1,-1,0,0};
    int[][] ch;
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        ch = new int[n+1][m+1];
        ch[1][1]=1;
        Queue<GPS> q = new LinkedList<>();
        q.offer(new GPS(1, 1));
        while(!q.isEmpty()){
            GPS tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>0 && nx<=n && ny>0 && ny<=m && maps[nx-1][ny-1]==1 && ch[nx][ny]==0){
                    ch[nx][ny]=ch[tmp.x][tmp.y]+1;
                    q.offer(new GPS(nx, ny));
                    if(nx==n && ny==m) return ch[n][m];
                }
            }
        }
        return ch[n][m]==0 ? -1 : ch[n][m];
    }
}

/*
 * 1. 맵은 n x m  1이상 100이하
 * 2. n = m = 1 인 경우는 없다.
 * 3. 0은 벽, 1은 통로
 * 4. 시작 위치 = (1,1), 상대방 진영 = (n,m)
 * 5. 이동 칸 수는 시작점 포함하여 계산.
 * 
 * 최단거리 -> BSQ
 * 0. Q와 Q에 넣을 클래스 GPS 생성
 *      동서남북 배열 생성  dx dy
 *      방문 기록 배열 생성 ch
 * 1. 시작점 위치를 Q에 넣는다.
 * 2. 이동칸 수 L = 1;
 * 3. while (!isEmpty)
 *    ₩₩  gps x = poll
*       새로운 인덱스 만들었을 때,
 *      for( 동 서 남 북)
 *          if 맵 안에 포함되고, 길에 포함된다면, 그리고 간 적이 없다면
 *              Q.offer(new GPS());
 *     
 * 
 */