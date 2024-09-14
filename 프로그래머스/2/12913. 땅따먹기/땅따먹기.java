class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<4; j++) {
                for(int k=0; k<4; k++) {
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i-1][k]);
                }
            }
        }
        
        int answer = 0;
        for(int k=0; k<4; k++) {
            answer = Math.max(answer, dp[land.length - 1][k]);
        }
        return answer;
    }
}