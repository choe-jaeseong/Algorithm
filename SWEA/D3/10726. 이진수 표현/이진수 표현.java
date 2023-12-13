
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());

        for(int t = 1; t <= testcase; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            //M 을 이진수로 표현
            String result = "";
            int Nbit = (1<<N) - 1;

            if((M&Nbit) == Nbit) result = "ON";
            else result = "OFF";

            System.out.println("#" + t + " " + result);
        }
    }
}
