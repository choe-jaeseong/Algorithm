package DFS_BFS;
import java.util.Scanner;

public class DBFS_10 {
    static int cnt = 0;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    static int[][] bd = new int[7][7];
    public void DFS(int i, int j){
        if(i==6 && j==6) cnt++;
        else {
            for(int k=0; k<4; k++){
                int nx = i+dx[k];
                int ny = j+dy[k];
                if(nx>=0 && nx<=6 && ny>=0 && ny<=6 && bd[nx][ny]==0){
                    bd[nx][ny]=1;
                    DFS(nx, ny);
                    bd[nx][ny]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        DBFS_10 T = new DBFS_10();
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                bd[i][j]=sc.nextInt();
            }
        }
        bd[0][0]=1; // 입력 꼭 하기!!!!!!!!!!!!!!
        T.DFS(0, 0);
        System.out.println(cnt);
        sc.close();
    }
}
