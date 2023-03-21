package DFS_BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 12. 토마토(BFS 활용)
class Point{
    int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class DBFS_12 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] bd, dis;
    static int n, m;
    static Queue<Point> Q = new LinkedList<>();
    public void BFS(){
        while(!Q.isEmpty()){
            Point tmp=Q.poll();
            for(int i=0; i<4; i++){
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && bd[nx][ny]==0){
                    bd[nx][ny]=1;                    //방문 안 한 곳은 0
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1; //걸리는 시간 측정.(이전 값에 +1)
                }
            }
        }
    }
    public static void main(String[] args) {
        DBFS_12 T = new DBFS_12();
        Scanner sc = new Scanner(System.in);
        m=sc.nextInt();
        n=sc.nextInt();
        bd = new int[n][m];
        dis = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                bd[i][j]=sc.nextInt();
                if(bd[i][j]==1) Q.offer(new Point(i,j));
            }
        }
        sc.close();
        T.BFS();
        int ans=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(bd[i][j]==0){            //방문 안 한 곳이 있다면, -1 출력.
                    System.out.println(-1);
                    return ;
                } else {
                    ans=Math.max(ans, dis[i][j]);   //모두 익었다면 다 익는 데 소요된 시간 출력.
                }
            }
        }
        System.out.println(ans);
    }
}
