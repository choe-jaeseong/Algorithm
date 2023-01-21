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
                    bd[nx][ny]=1;
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
        T.BFS();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(dis[i][j]+" ");
            }
            System.out.println();
        }
        boolean flag = true;   //익지 않은 과일이 있는지 체크
        int ans=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(bd[i][j]==0) flag=false;
            }
        }
        if(flag){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    ans=Math.max(ans, dis[i][j]);
                }
            }
            System.out.println(ans);
        }
        else System.out.println(-1);

        sc.close();
    }
}
