import java.util.Scanner;

public class GREEDY_01 {
    public int solution(int n, int[][] arr){
        int cnt = 0, ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) break;
                else cnt++;
                System.out.println(i + " " + j + " " + cnt);
                if(cnt==n-1) ans++;
            }
            cnt=0;
        }
        return ans;
    }
    public static void main(String[] args) {
        GREEDY_01 T = new GREEDY_01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));;
        sc.close();
    }
}
