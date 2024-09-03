import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = getGCD(a, b);
            System.out.println("#" + t + " " + result);
        }
    }

    private static int getGCD(int a, int b) {
        int result = 1;
        for(int i=a; i>=2; i--) {
            if(i > b) continue;
            if(b % i == 0) {
                result *= i;
                b /= i;
            }
        }
        return result;
    }
}
