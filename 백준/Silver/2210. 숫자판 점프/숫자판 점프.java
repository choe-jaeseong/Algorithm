import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	private static Set<Integer> set = new HashSet<>();
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] arr = new int[5][5];
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				DFS(arr, i, j, arr[i][j], 1);
			}
		}
		
		System.out.println(set.size());
	}
	
	private static void DFS(int[][] arr, int x, int y, int result, int L) {
		if(L==6) {
			set.add(result);
			return;
		}
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<5 && ny>=0 && ny<5) {
				DFS(arr, nx, ny, result * 10 + arr[nx][ny], L+1);
			}
		}
	}
}

