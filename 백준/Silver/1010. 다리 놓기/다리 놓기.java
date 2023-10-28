import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            dp = new int[m+1][n+1];
            int result = combination(m, n);
            System.out.println(result);
        }
    }

    private static int combination(int n, int m) {
        if(dp[n][m] > 0) return dp[n][m];
        if(m==1) return n;
        if(n==m || n==0) return 1;
        else return dp[n][m] = combination(n-1, m-1) + combination(n-1, m);
    }
}
