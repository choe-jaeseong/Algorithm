package DFS_BFS;
import java.util.Scanner;

//14. 섬나라 아일랜드(BFS)
public class DBFS_14 {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    static int n, m, x0, y0, cnt=0, ans=Integer.MIN_VALUE;
    static int[][] arr;
    boolean flag;
    public void DFS(int L, int x, int y, int[][] arr){
        if(flag == true) return ;
        if(cnt == m) return ;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n){
                System.out.println("L: "+L+", nx: "+nx+", ny: "+ny+", arr[nx][ny]: "+arr[nx][ny]+", flag: "+flag);
                if(arr[nx][ny]==0) DFS(L+1, nx, ny, arr);
                else if(arr[nx][ny]==1) return ;
                else {
                    flag=true;
                    cnt++;
                    ans = Math.max(L, Math.abs(x0-nx)+Math.abs(y0-ny));
                }
            }
        }
    }
    public void solution(int[][] arr){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==1){
                    flag=false;
                    x0=i;
                    y0=j;
                    DFS(1, i, j, arr);
                }
            }
        }
    }
    public static void main(String[] args) {
        DBFS_14 T = new DBFS_14();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(ans);
        sc.close();
    }
}
