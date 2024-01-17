import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Bus {
        int dest;
        int time;

        Bus(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }
    }

    static ArrayList<Bus>[] routes;
    static int[] taken;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        routes = new ArrayList[n + 1];
        for(int i=0; i<n + 1; i++) routes[i] = (new ArrayList<>());

        taken = new int[n + 1];
        Arrays.fill(taken, INF);

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            routes[from].add(new Bus(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        Dijkstra(from, to);

        System.out.println(taken[to]);
    }

    private static void Dijkstra(int from, int to) {
        PriorityQueue<Bus> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
        Q.add(new Bus(from, 0));
        taken[from] = 0;

        while(!Q.isEmpty()) {
            Bus now = Q.poll();
            if(now.dest == to) break;

            for(Bus next : routes[now.dest]) {
                if(taken[next.dest] > taken[now.dest] + next.time) {
                    taken[next.dest] = taken[now.dest] + next.time;
                    Q.add(new Bus(next.dest, taken[next.dest]));
                }
            }
        }
    }
}