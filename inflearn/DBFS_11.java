import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    public int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class DBFS_11 {
    static int[][] bd, dis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        bd[x][y]=1;
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && bd[nx][ny]==0){
                    System.out.println("("+nx+", "+ny+")");
                    bd[nx][ny]=1;
                    Q.offer(new Point(nx,ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        DBFS_11 T = new DBFS_11();
        Scanner sc = new Scanner(System.in);
        bd = new int[8][8];
        dis= new int[8][8];
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                bd[i][j] = sc.nextInt();
            }
        }
        T.BFS(1,1);
        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
        sc.close();
    }
}
