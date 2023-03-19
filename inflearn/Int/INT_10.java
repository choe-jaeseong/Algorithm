package Int;
//10. 봉우리
import java.util.Scanner;

public class INT_10 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    public int solution(int n, int[][] arr){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                boolean flag = true;
                for (int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] >= arr[i][j]){
                        flag = false;
                        break;
                    }
                }
                if (flag) cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        INT_10 T = new INT_10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[50][50];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
        sc.close();
        return ;
    }
}


//Runtime Error
// import java.util.Scanner;

// public class INT_10 {
    
//     public int solution(int n, int[][] arr){
//         int cnt = 0;
//         for(int i = 1; i <= n; i++){
//             for (int j = 1; j <= n; j++){
//                 if (arr[i][j] > arr[i-1][j]){
//                     if (arr[i][j] > arr[i][j-1]){
//                         if (arr[i][j] > arr[i+1][j]){
//                             if (arr[i][j] > arr[i][j+1]){
//                                 cnt++;
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return cnt;
//     }

//     public static void main(String[] args){
//         INT_10 T = new INT_10();
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[][] arr = new int[50][50];
//         for (int i = 1; i <= n; i++){
//             for (int j = 1; j <= n; j++){
//                 arr[i][j]=sc.nextInt();
//             }
//         }
//         for (int i = 0; i <= n+1; i++){
//             arr[0][i] = arr[i][0] = 0;
//             arr[n+1][i] = arr[i][n+1] = 0;
//         }
//         System.out.println(T.solution(n, arr));
//         sc.close();
//         return ;
//     }
// }
