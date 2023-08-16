package Magnetic_2일차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    //1 : red, 2: blue
    private static int countCol(int[][] arr, int col) {
        int count = 0;
        boolean isN = false;
        for(int i=0; i<100; i++) {
            if(arr[i][col]==0) continue;
            if(isN==false) {
                if(arr[i][col]==2) continue;
                else isN = true;
            }
            else {
                if(arr[i][col]==2) {
                    count++;
                    isN = false;
                } 
            }
        }
        return count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr;
        
        for(int T=1; T<=10; T++) {
            br.readLine();
            //지도 입력
            arr = new int[100][100];
            for(int i=0; i<100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //열 순회
            int sum = 0;
            for(int i=0; i<100; i++) {
                sum += countCol(arr, i);
            }
            System.out.println("#"+T+" "+sum);
        }
    }
}