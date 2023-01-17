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
