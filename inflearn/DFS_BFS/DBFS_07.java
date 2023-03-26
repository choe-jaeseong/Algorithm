package DFS_BFS;
// 7. 조합의 경우수(메모이제이션)
import java.util.Scanner;

public class DBFS_07 {
    int[][] dy=new int[35][35];
    public int DFS(int n, int r){
        if(dy[n][r]>0) return dy[n][r];  //메모이제이션 : 동일한 연산을 방지. 저장된 값이 있다면 리턴. (연산 줄임)
        if(r==0) return 1;
        if(n==r) return 1;
        else return dy[n][r]=DFS(n-1, r-1)+DFS(n-1, r);  //메서드값을 리턴하면서 배열에 저장.
    }
    
    public static void main(String[] args) {
        DBFS_07 T = new DBFS_07();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(T.DFS(n,m));
        sc.close();
    }
}
