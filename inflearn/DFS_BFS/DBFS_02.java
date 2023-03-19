package DFS_BFS;
import java.util.Scanner;

// 2. 바둑이 승차(DFS)
//강의 답
public class DBFS_02 {
    static int w, n, ans=Integer.MIN_VALUE;
    public void DFS(int L, int sum, int[] arr){
        if(sum>w) return;
        if(L==n){
            ans = Math.max(ans, sum);
        }
        else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        DBFS_02 T = new DBFS_02();
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();
        T.DFS(0,0,arr);
        System.out.println(ans);
        sc.close();
    }
}

//나의 답
// public class DBFS_02 {
//     static int w, n, max=0;
//     static int[] arr;
//     public void DFS(int L, int sum){
//         if(sum>w) return;
//         if(L==n){
//             if(max<sum) max = sum;
//         }
//         else {
//             DFS(L+1, sum+arr[L]);
//             DFS(L+1, sum);
//         }
//     }

//     public static void main(String[] args) {
//         DBFS_02 T = new DBFS_02();
//         Scanner sc = new Scanner(System.in);
//         w = sc.nextInt();
//         n = sc.nextInt();
//         arr = new int[n];
//         for(int i=0; i<n; i++) arr[i]=sc.nextInt();
//         int sum = 0;
//         T.DFS(0, sum);
//         System.out.println(max);
//         sc.close();
//     }
// }
