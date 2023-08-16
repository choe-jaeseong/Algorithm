package View_1일차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    private static int countView(int[] buildings, int i) {
        int max_height = 0;
        for(int j=i-2; j<=i+2; j++) {
            if(j==i) continue;
            if(j < 0) continue;
            if(j >= buildings.length) continue;
             
            max_height = max_height < buildings[j] ? buildings[j] : max_height;
        }
         
        int answer = buildings[i] - max_height;
        return answer > 0 ? answer : 0;
    }
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        for(int T=1; T<=10; T++) {
            int answer = 0;
            int N = Integer.parseInt(br.readLine());
             
            //1. building 높이 입력
            int[] buildings = new int[N];
            st = new StringTokenizer(br.readLine());
            int i=0;
            while(st.hasMoreTokens()) {
                buildings[i++] = Integer.parseInt(st.nextToken());
            }
             
            //2. 각 건물마다 조망권 확인
            for(i=0; i<buildings.length; i++) {
                answer += countView(buildings, i);
            }
             
            System.out.println("#"+T+" "+answer);
        }
    }
}