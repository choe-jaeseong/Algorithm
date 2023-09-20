import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 1;

        for(int i=2; i<=N; i++){
            int min = 5;
            for (int j = 1; j*j <= i; j++) {
                min = Math.min(min, dp[i-j*j]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[N]);
    }
}

/*
dp
1 = 1
2 = 1 + 1
3 = 1 + 1 + 1
4 = 2
5 = 2 + 1
6 = 2 + 1 + 1
7 = 2 + 1 + 1 + 1
8 = 2 + 2
9 = 3
10 = 3 + 1
11 = 3 + 1 + 1
12 = 3 + 1 + 1 + 1
13 = 3 + 2
14 = 3 + 2 + 1
15 = 3 + 2 + 1 + 1
16 = 4
17 = 4 + 1
 */