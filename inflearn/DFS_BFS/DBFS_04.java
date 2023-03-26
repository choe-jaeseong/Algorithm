package DFS_BFS;
import java.util.Scanner;

//강의 답
public class DBFS_04 {
    static int n, m;
    static int[] arr;
    public void DFS(int L){
        if(L==m) {
            for(int x: arr) System.out.print(x + " ");
            System.out.println();
        }
        else {
            for(int i=1; i<=n; i++){
                arr[L] = i;
                DFS(L+1);
            }
        }
    }
    public static void main(String[] args) {
        DBFS_04 T = new DBFS_04();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        T.DFS(0);
        sc.close();
    }
}


//나의 답
// public class DBFS_04 {
//     static int n, m;
//     public void DFS(int k, String str){
//         if(k==m) System.out.println(str);
//         else {
//             for(int i=1; i<=n; i++){
//                 DFS(k+1, str+i);
//             }
//         }
//     }
//     public static void main(String[] args) {
//         DBFS_04 T = new DBFS_04();
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         m = sc.nextInt();
//         T.DFS(0, "");
//         sc.close();
//     }
// }

//나의 답 (ans String 이용)
// public class practice {
//     static int n, m;
//     static String ans = "";
//     public void DFS(int L){
//         if(L==m){
//             for(char x : ans.toCharArray()){
//                 System.out.print(x+" ");
//             }
//             System.out.println();
//         } else {
//             for(int i=1; i<=n; i++){
//                 ans += i;
//                 DFS(L+1);
//                 ans = ans.substring(0,ans.length()-1);
//             }
//         }
//     }
//     public static void main(String[] args) {
//         practice T = new practice();
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         m = sc.nextInt();
//         T.DFS(0);
//         sc.close();
//     }
// }
