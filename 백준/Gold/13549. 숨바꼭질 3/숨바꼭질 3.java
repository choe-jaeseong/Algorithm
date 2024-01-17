import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Move {
        int to;
        int time;

        Move(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    static int[] dist = new int[100_001];
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, INF);
        Dijkstra(N, K);
        System.out.println(dist[K]);
    }

    private static void Dijkstra(int n, int k) {
        PriorityQueue<Move> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1.time, o2.time));
        pq.add(new Move(n, 0));
        dist[n] = 0;

        while(!pq.isEmpty()) {
            Move now = pq.poll();
            if(now.to == k) break;

            for(int i=0; i<3; i++) {
                int next = act(now.to, i);
                int cost = i==0 || i==1 ? 1 : 0;
                if(next < 0 || next > 100_000) continue;
                if(dist[next] > dist[now.to] + cost) {
                    dist[next] = dist[now.to] + cost;
                    pq.add(new Move(next, dist[next]));
                }
            }
        }
    }

    private static int act(int to, int i) {
        if(i==0) return to - 1;
        else if(i==1) return to + 1;
        else if(i==2) return to * 2;
        else return -1;
    }
}