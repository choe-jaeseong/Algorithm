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
// public class practice {
//     static int limit_weight, answer=0;
//     static int n;
//     static int[] arr_weight;
//     public void DFS(int L, int sum){
//         if(sum>limit_weight) return;
//         if(L==n){
//             if(sum<=limit_weight) 
//                 answer = Math.max(answer, sum);
//         } else {
//             DFS(L+1, sum + arr_weight[L]);
//             DFS(L+1, sum);
//         }
//     }
//     public static void main(String[] args) {
//         practice T = new practice();
//         Scanner sc = new Scanner(System.in);
//         limit_weight = sc.nextInt(); 
//         n = sc.nextInt();
//         arr_weight = new int[n];
//         for(int i=0; i<n; i++){
//             arr_weight[i] = sc.nextInt();
//         }
//         T.DFS(0, 0);
//         System.out.println(answer);
//         sc.close();
//     }
// }
