import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] dx = {0,0,-1,1};
	private static int[] dy = {-1,1,0,0};
	private static boolean isSeparated(int[][] icebergs) {
		int count = 0;
		int[][] check = new int[icebergs.length][icebergs[0].length];
		for(int i=0; i<check.length; i++) {
			for(int j=0; j<check[0].length; j++) {
				if(check[i][j]==0 && icebergs[i][j]>0) {
					count++;
					if(count>=2) return true;
					DFS(icebergs, check, i, j);
				}
			}
		}
		return false;
	}
	private static void DFS(int[][] icebergs, int[][] check, int x, int y) {
		check[x][y] = 1;
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx >= 0 && nx < check.length && ny >= 0 && ny < check[0].length && icebergs[nx][ny]>0 && check[nx][ny]==0) {
				DFS(icebergs, check, nx, ny);
			}
		}
	}
	private static int[][] melted(int[][] icebergs) {
		int[][] arr = new int[icebergs.length][icebergs[0].length];
		for(int i=0; i<icebergs.length; i++) {
			arr[i] = icebergs[i].clone();
		}
		for(int i=0; i<icebergs.length; i++) {
			for(int j=0; j<icebergs[0].length; j++) {
				if(icebergs[i][j] > 0) {
					arr[i][j] -= countOcean(icebergs, i, j);
					arr[i][j] = arr[i][j] < 0 ? 0 : arr[i][j];
				}
			}
		}
		icebergs = arr;
		return icebergs;
	}
	private static int countOcean(int[][] icebergs, int x, int y) {
		int count = 0;
		for(int k=0; k<4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx >= 0 && nx < icebergs.length && ny >= 0 && ny < icebergs[0].length && icebergs[nx][ny]==0) {
				count++;
			}
		}
		return count;
	}
	private static boolean isAllMelted(int[][] icebergs) {
		for (int i = 0; i < icebergs.length; i++) {
			for (int j = 0; j < icebergs[0].length; j++) {
				if(icebergs[i][j]!=0) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] icebergs = new int[r][c];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				icebergs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int taken = 0;
		while(!isSeparated(icebergs)) {
			if(isAllMelted(icebergs)) {
				taken = 0;
				break;
			}
			icebergs = melted(icebergs);
			taken++;
		}
		System.out.println(taken);
	}
	
}

/*
 * 1. 빙산의 높이를 입력받는다.
 * 2. 분리된 빙산의 수를 체크한 후, 2 이상이면 이때의 시간 출력. return.
 * 3. 빙산이 녹는다.(각각의 빙산이 얼마나 녹는지 계산하는 함수 필요)
 */