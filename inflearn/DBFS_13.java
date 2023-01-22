import java.util.Scanner;

public class DBFS_13 {
    int[] dx = {1,1,0,-1,-1,-1,0,1};
    int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int n, cnt=0;
    static int[][] bd;
    public void DFS(int L, int x, int y){
        if(bd[x][y]==0) return ;
        else {
            bd[x][y]=0;
            for(int i=0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && bd[nx][ny]==1)
                    DFS(L+1, nx, ny);
            }
            if(L==0) {
                // System.out.println("("+x+", "+y+")");
                cnt++;
            }
        }
        
    }
    public static void main(String[] args) {
        DBFS_13 T = new DBFS_13();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        bd = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                bd[i][j]=sc.nextInt();
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                T.DFS(0,i,j);
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}
