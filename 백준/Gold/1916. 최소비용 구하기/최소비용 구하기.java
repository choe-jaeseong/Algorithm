import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<int[]>> routes = new ArrayList<>();
    static int[] costs;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<n + 1; i++) routes.add(new ArrayList<>());
        costs = new int[n + 1];
        Arrays.fill(costs, INF);
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            routes.get(from).add(new int[] {to, cost});
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        Dijkstra(from, to);

        System.out.println(costs[to]);
    }

    private static void Dijkstra(int from, int to) {
        boolean[] visited = new boolean[costs.length];
        visited[from] = true;
        costs[from] = 0;

        PriorityQueue<int[]> Q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for(int[] bus : routes.get(from)) Q.add(bus);

        while(!Q.isEmpty()) {
            int[] bus = Q.poll();
            if(visited[bus[0]] == true) continue;
            visited[bus[0]] = true;

            if(costs[bus[0]] > bus[1]) {
                costs[bus[0]] = bus[1];
                for(int[] next : routes.get(bus[0]))
                    if(visited[next[0]] == false)
                        Q.add(new int[]{next[0], bus[1] + next[1]});
            }
        }
    }
}