import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] dp = new int[1000_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<=N; i++) {
            int one = dp[i - 1];
            int two = i % 2 == 0 ? dp[i/2] : Integer.MAX_VALUE;
            int three = i % 3 == 0 ? dp[i/3] : Integer.MAX_VALUE;
            dp[i] = Math.min(one, Math.min(two, three)) + 1;
        }

        System.out.println(dp[N]);
    }
}