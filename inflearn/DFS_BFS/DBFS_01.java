package DFS_BFS;
import java.util.Scanner;

// 1. 합이 같은 부분집합(DFS : 아마존 인터뷰)
//강의 답
public class DBFS_01 {
    static int n, total = 0;
    static String ans = "NO";
    boolean flag = false;
    public void DFS(int L, int sum, int[] arr){
        if(flag) return ;
        if(L==n){
            if((total-sum)==sum){
                ans="YES";
                flag=true;
            }
        }
        else{
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        DBFS_01 T = new DBFS_01();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            total+=arr[i];
        }
        T.DFS(0,0,arr);
        System.out.println(ans);
        sc.close();
    }
}

//나의 답
// public class DBFS_01 {
//     static int n;
//     static int[] arr;
//     static int sum1=0, sum2=0;
//     static String ans = "NO";

//     public void DFS(int k){
//         if(ans!="NO") return;
//         if(k==n){
//             if(sum1==sum2) ans = "YES";
//         } else {
//             sum1+=arr[k];
//             DFS(k+1);
//             sum1-=arr[k];
//             sum2+=arr[k];
//             DFS(k+1);
//             sum2-=arr[k];
//         }
//     }

//     public static void main(String[] args) {
//         DBFS_01 T = new DBFS_01();
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         arr = new int[n];
//         for(int i=0; i<n; i++) arr[i] = sc.nextInt();
//         T.DFS(0);
//         System.out.println(ans);
//         sc.close();
//     }
// }
