package 최빈수구하기_1일차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        for(int i=0; i<T; i++) {
            int Test_number = Integer.parseInt(br.readLine());
            int mode = 0; //최빈값
            int count = 0;
            int[] distribution = new int[101];
             
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                int score = Integer.parseInt(st.nextToken());
                distribution[score]++;
                if(count == distribution[score]) {
                    if(mode < score) 
                        mode = score;
                } else if (count < distribution[score]) {
                    mode = score;
                    count = distribution[score];
                }
            }
             
            System.out.println("#" + Test_number + " " + mode);
        }
    }
}