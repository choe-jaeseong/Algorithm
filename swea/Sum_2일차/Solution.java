package Sum_2일차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int[][] arr;
        for(int T = 1; T <= 10; T++){
            br.readLine();
            int max=0, max1=0, max2=0, max3=0, max4=0; //행, 열, 왼쪽대각선, 오른쪽 대각선
            arr = new int[100][100];

            //배열 입력 받기 (100 x 100)
            for(int i=0; i<100; i++){
                int j = 0;
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()) arr[i][j++] = Integer.parseInt(st.nextToken());
            }
            
            //행, 열, 대각선(왼쪽), 대각선(오른쪽) : max1, max2, max3, max4
            for(int i=0; i<100; i++){
                max1=0;
                max2=0;
                for(int j=0; j<100; j++){
                    max1 += arr[i][j];
                    max2 += arr[j][i];
                }
                max = max < max1 ? max1 : max;
                max = max < max2 ? max2 : max;
                
                max3 += arr[i][i];
                max4 += arr[i][99-i];
            }
            max = max < max3 ? max3 : max;
            max = max < max4 ? max4 : max;
            
            System.out.println("#"+T+" "+max);
        }
    }
}
