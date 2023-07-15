package 숫자배열회전;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            //데이터 입력
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            System.out.println("#"+test_case);
            for(int i = 0; i < n; i++){
                for(int j=n-1; j>=0; j--){
                    System.out.print(arr[j][i]);
                }
                System.out.print(" ");
                for(int k=n-1; k>=0; k--){
                    System.out.print(arr[n-1-i][k]);
                }
                System.out.print(" ");
                for(int m=0; m<n; m++){
                    System.out.print(arr[m][n-1-i]);
                }
                System.out.println();
            }
		}
        sc.close();
    }
}
