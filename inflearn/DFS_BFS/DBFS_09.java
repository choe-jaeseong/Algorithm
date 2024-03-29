package DFS_BFS;
import java.util.Scanner;

//9. 조합구하기 (ch[] 사용 x, DFS 매개변수에 시작점 s 추가)
public class DBFS_09 {
    static int n, m;
    static int[] pm;
    public void DFS(int L, int s){
        if(L==m){
            for(int x: pm) System.out.print(x + " ");
            System.out.println();
        }
        else{
            for(int i=s; i<=n; i++){
                pm[L]=i;
                DFS(L+1, i+1);  //i+1 부터 시작된다.
            }
        }
    }
    public static void main(String[] args) {
        DBFS_09 T = new DBFS_09();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        T.DFS(0, 1);
        sc.close();
    }
}
