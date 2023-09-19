import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N==0) break;
			
			int MAX = Integer.MIN_VALUE, sum = 0;
			for (int i = 0; i < N; i++) {
				int sale = Integer.parseInt(br.readLine());
				sum += sale;
				MAX = Math.max(MAX, sum);
				
				if(sum<0) sum = 0;
			}
			System.out.println(MAX);
		}
	}
}

/*
 * DP
 * target = 0부터 현재 위치까지 가질 수 있는 최대 점수
 * dp[k] = Math.max(sales[k], sales[k] + dp[k-1]);
 */