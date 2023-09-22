import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N==4) {
			System.out.println(-1);
			return;
		}
		if(N==3 || N==5) {
			System.out.println(1);
			return;
		}
		
		int[] dp = new int[N+1];
		dp[3] = 1;
		dp[5] = 1;
		
		for(int i=6; i<=N; i++) {
			int a = dp[i-3];
			int b = dp[i-5];
			if(a==0 && b==0) {
				continue;
			} else if (a==0) {
				dp[i] = b + 1;
			} else if (b==0) {
				dp[i] = a + 1;
			} else {
				dp[i] = Math.min(a, b) + 1;
			}
		}

		if(dp[N]==0) System.out.println(-1);
		else System.out.println(dp[N]);
	}
}
