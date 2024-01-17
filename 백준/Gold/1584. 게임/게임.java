import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Move {
        int x;
        int y;
        int cost;
        Move(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] board = new int[501][501];
    static int[][] costs = new int[501][501];
    static int[][] visited = new int[501][501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //위험 구역
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            fill(x1, y1, x2, y2, 1);
        }
        //죽음 구역
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            fill(x1, y1, x2, y2, 2);
        }

        //다익스트라 알고리즘
        Dijkstra();

        //결과 출력
        if(costs[500][500] == -1) System.out.println(-1);
        else System.out.println(costs[500][500]);
    }

    private static void Dijkstra() {
        PriorityQueue<Move> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Move(0, 0, 0));
        costs[0][0] = -1;
        visited[0][0] = 1;
        costs[500][500] = -1;

        while(!pq.isEmpty()) {
            Move now = pq.poll();
            if(now.x == 500 && now.y == 500) break;

            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx>=0 && nx<board.length && ny>=0 && ny<board.length) {
                    if(board[nx][ny] != 2 && visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        costs[nx][ny] = now.cost + board[nx][ny];
                        pq.offer(new Move(nx, ny, costs[nx][ny]));
                    }
                }
            }
        }
    }

    private static void fill(int x1, int y1, int x2, int y2, int v) {
        if(x1 > x2) {
            int tmp = x1;
            x1 = x2;
            x2 = tmp;
        }
        if(y1 > y2) {
            int tmp = y1;
            y1 = y2;
            y2 = tmp;
        }
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                board[i][j] = v;
            }
        }
    }
}
