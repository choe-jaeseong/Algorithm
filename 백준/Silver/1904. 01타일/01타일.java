import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		if(N==1) {
			System.out.println(1);
			return;
		}
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i=3; i<=N; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 15746;
		}
		
		System.out.println(arr[N]);
	}
}
