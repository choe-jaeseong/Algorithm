import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static char[][] board;
    private static boolean[] visited = new boolean[26];
    private static int MAX = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        //보드 입력
        board = new char[R][C];
        for (int i=0; i<R; i++) {
            char[] rowArr = br.readLine().toCharArray();
            for (int j=0; j<C; j++) {
                board[i][j] = rowArr[j];
            }
        }

        //좌측 상단에 말 놓기
        int x = 0;
        int y = 0;
        visited[board[x][y] - 65] = true;

        //backTracking
        DFS(1, x, y);

        System.out.println(MAX);
    }

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    private static void DFS(int L, int x, int y) {
        MAX = Math.max(MAX, L);

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                char c = board[nx][ny];
                if(visited[c - 65] == false) {
                    visited[c - 65] = true;
                    DFS(L + 1, nx, ny);
                    visited[c - 65] = false;
                }
            }
        }
    }

}
/*
1. 보드 값을 입력받는다.
2. 좌측 상단의 알파벳을 check 배열에 표시한다.
3. backtracking 으로 이동할 수 있는 최대 깊이를 갱신한다.
 */