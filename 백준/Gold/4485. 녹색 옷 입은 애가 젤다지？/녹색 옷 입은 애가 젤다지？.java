import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] arr;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int t=1; ; t++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            arr = new int[n][n];
            visited = new int[n][n];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = dijkstra();
            bw.write("Problem " + t + ": " + answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(0,0, arr[0][0]));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.x == arr.length - 1 && cur.y == arr.length - 1) return cur.cost;
            if(visited[cur.x][cur.y] == 1) continue;

            visited[cur.x][cur.y] = 1;
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx>=0 && nx<arr.length && ny>=0 && ny<arr.length) {
                    if(visited[nx][ny] == 0) {
                        pq.add(new Node(nx, ny, cur.cost + arr[nx][ny]));
                    }
                }
            }
        }
        return 0;
    }

    static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
