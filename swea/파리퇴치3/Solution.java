package 파리퇴치3;

import java.util.Scanner;

public class Solution {
    private int countXShape(int[][] arr, int x, int y, int n){
        int sum = 0;
        
        return sum;
    }
    private int countCrossShape(int[][] arr, int x, int y, int n){
        int sum = 0;
        
        return sum;
    }
    public static void main(String[] args) throws Exception{
        Solution S = new Solution();
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    arr[i][j] = sc.nextInt();
                }                
            }
            System.out.println("#"+test_case+" "+answer);
		}
        sc.close();
    }
}
