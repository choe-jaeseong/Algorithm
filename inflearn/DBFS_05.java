import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 5. 동전교환
public class DBFS_05 {
    static int n, m, ans=Integer.MAX_VALUE;
    public void DFS(int L, int sum, Integer[] arr){
        if(sum>m) return ;
        if(L>=ans) return ;
        if(sum==m) ans=Math.min(ans, L);
        else {
            for(int i=0; i<n; i++){
                DFS(L+1, sum+arr[i], arr);
            }
        }
    }
    
    public static void main(String[] args) {
        DBFS_05 T = new DBFS_05();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());
        m = sc.nextInt();
        T.DFS(0,0,arr);
        System.out.println(ans);
        sc.close();
    }
}
