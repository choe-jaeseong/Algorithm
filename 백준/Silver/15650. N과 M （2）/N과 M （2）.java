import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		DFS(0, new int[M], new int[N], 0);
	}
	
	private static void DFS(int L, int[] answer, int[] check, int last) {
		if(L==answer.length) {
			for(int x : answer) System.out.print(x + " ");
			System.out.println();
			return;
		}
		for(int i=last; i<check.length; i++) {
			if(check[i]==0) {
				check[i]=1;
				answer[L]=i+1;
				DFS(L+1, answer, check, i);
				check[i]=0;
			}
		}
	}
}
