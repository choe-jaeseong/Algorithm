package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class practice {
    static int n, m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] bd;
    static Queue<Point> Q = new LinkedList<>();
    public void BFS(){
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && bd[nx][ny]==0){
                    bd[nx][ny]=bd[tmp.x][tmp.y]+1;
                    Q.offer(new Point(nx, ny));
                }
            }
        }
    }
    public static void main(String[] args) {
        practice T = new practice();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        bd = new int[n][m];
        boolean flag = true;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                bd[i][j]=sc.nextInt();
                if(bd[i][j]==0) flag = false;
                else if(bd[i][j]==1) Q.offer(new Point(i,j));
            }
        }
        T.BFS();
        int max = 0;
        if(flag) System.out.println(0);
        else {
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(bd[i][j]==0){
                        System.out.println(-1);
                        return ;
                    } else if(bd[i][j]>max){
                        max = bd[i][j];
                    }
                }
            }
            System.out.println(max);
        }
        sc.close();
    }
}
