package Ladder1_2일차;

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
        //지도 입력
        for(int T=1; T<=10; T++) {
            br.readLine();
            arr = new int[100][100];
            for(int i=0; i<100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            //1. 도착지점 찾기
            int row = 99;
            int col = 0;
            for(int i=0; i<100; i++) {
                if(arr[99][i]==2) {
                    col = i;
                    break;
                }
            }

            //2. 반복문 시작
            while(row>0) {
                if(col+1<100 && arr[row][col+1]==1) {
                    while(col+1<100 && arr[row][col+1]!=0) col++;
                } else if (col-1>0 && arr[row][col-1]==1) {
                    while(col-1>0 && arr[row][col-1]!=0) col--;
                }
                row--;
            }
            System.out.println("#"+T+" "+col);
        }
    }
}