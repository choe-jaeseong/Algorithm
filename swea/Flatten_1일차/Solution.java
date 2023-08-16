package Flatten_1일차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        for(int T=1; T<=10; T++) {
            int d = Integer.parseInt(br.readLine());
             
            //1. 100개의 칸에 높이를 입력받는다.
            int[] land = new int[100];
            st = new StringTokenizer(br.readLine());
            int i = 0;
            while(st.hasMoreTokens()) {
                land[i++] = Integer.parseInt(st.nextToken());
            }
             
            while(d-- > 0) {
                Arrays.sort(land);
                land[0]++;
                land[99]--;
            }
            Arrays.sort(land);
            System.out.println("#"+T+" "+(land[99] - land[0]));
        }
         
        br.close();
    }
}
/*
 * 1. 100개의 칸에 높이를 입력받는다.
 * 2. 100개를 정렬한다.
 * 3. 높은 칸을 줄이고, 낮은 칸을 높인다.
 *    d 만큼 2번부터 다시 반복
 */
