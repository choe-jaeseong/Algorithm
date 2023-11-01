import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[][] arr;
	private static boolean[][] ch;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		arr = new int[r][c];
		int[] start = new int[2];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					start[0] = i;
					start[1] = j;
				}
			}
		}

//		System.out.println(start[0] + " " + start[1]);

		// 맵 정보 바꾸기
		changeMap(start);
		
		// 도달할 수 없는 위치 바꾸기
		changeCannotReach();

		// 결과 출력
		for (int[] x : arr) {
			for (int y : x)
				System.out.print(y + " ");
			System.out.println();
		}
	}

	private static void changeCannotReach() {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(ch[i][j] == false && arr[i][j] == 1) {
					arr[i][j] = -1;
				}
			}
		}
	}

	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };

	private static void changeMap(int[] start) {
		ch = new boolean[arr.length][arr[0].length];
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		arr[start[0]][start[1]] = 0;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			ch[tmp[0]][tmp[1]] = true;
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if (!(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length))
					continue;
				if (ch[nx][ny] == true)
					continue;
				if (arr[nx][ny] == 1) {
					arr[nx][ny] = arr[tmp[0]][tmp[1]] + 1;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}
}
