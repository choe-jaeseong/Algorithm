// 9. 격자판 최대합
import java.util.*;

public class INT_09 {

    public int solution(int n, int[][] arr){
        int max = Integer.MIN_VALUE;
        int sum1, sum2;
        for (int i = 0; i < n; i++){
            sum1=sum2=0;
            for (int j = 0; j < n; j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            max=Math.max(max, sum1);
            max=Math.max(max, sum2);
        }
        sum1=sum2=0;
        for (int i = 0; i < n; i++){
            sum1 += arr[i][i];
            sum2 += arr[n-1-i][i];
        }
        max=Math.max(max, sum1);
        max=Math.max(max, sum2);
        
        return max;
    }

    public static void main(String[] args){
        INT_09 T = new INT_09();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[50][50];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
        sc.close();
        return ;
    }
    
}
