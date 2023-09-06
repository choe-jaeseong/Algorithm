import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//정보 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int start = 1, end = 1;
		int[] jewels = new int[M];
		for(int i=0; i<M; i++) {
			jewels[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, jewels[i]);
		}
		
		while(start < end) {  //질투심(나눠준 것들 중 최댓값)
			int mid = (start + end) / 2;
			if(isPossible(mid, jewels, N)) end = mid;
			else start = mid + 1;
		}
		System.out.println(end);
	}

	private static boolean isPossible(int mid, int[] jewels, int N) {
		int count = 0;
		for(int jewel : jewels) {
			count += jewel / mid;
			count = jewel % mid > 0 ? count + 1 : count;
		}
		if(count > N) return false;
		else return true;
	}
}
/*
 * 최댓값이 최소가 되도록 하는 수
 * target = 질투심
 * start = 1  end = 최댓값
 * 최대 질투심보다 작게 덩어리를 만들었을 때,	가능하면 end = mid
 * 								불가능하면 start = mid + 1
 * 
 */