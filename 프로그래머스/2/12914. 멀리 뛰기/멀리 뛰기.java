import java.util.*;

class Solution {
    public long solution(int n) {
        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return dp[n];
    }
}

// DP = i까지 갈 수 있는 방법의 수
// dp[i] = dp[i-1] + dp[i-2];