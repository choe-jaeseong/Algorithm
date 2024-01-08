import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[15];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i=4; i<=target; i++)
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

            System.out.println(dp[target]);
        }
    }
}
