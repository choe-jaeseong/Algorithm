import java.util.Scanner;

public class DBFS_08 {
    static int n, m;
    static int[] w, ans, check;
    boolean flag = false;
    int[][] dy = new int[35][35];
    public int combi(int n, int r){
        if(dy[n][r]>0) return dy[n][r];
        if(r==0||n==r) return 1;
        else return dy[n][r]=combi(n-1, r-1)+combi(n-1, r);
    }

    public void DFS(int L, int sum){
        if(flag==true) return ;
        if(L==n){
            if(sum==m){
                for(int x : ans) System.out.print(x + " ");
                flag = true;
            }
        }
        else {
            for(int i=1; i<=n; i++){
                if(check[i]==0){
                    check[i]=1;
                    ans[L]=i;
                    DFS(L+1, sum + i * w[L]);
                    check[i]=0;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        DBFS_08 T = new DBFS_08();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        w = new int[n];
        ans = new int[n];
        check = new int[n+1];
        for(int i=0; i<n; i++) w[i] = T.combi(n-1,i);
        T.DFS(0,0);
        sc.close();
    }
}
