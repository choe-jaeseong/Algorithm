import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<ArrayList<Road>> roads = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        for(int i=0; i<N+1; i++) roads.add(new ArrayList<>());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            roads.get(a).add(new Road(b, c));
            roads.get(b).add(new Road(a, c));
        }

        //최소 신장 트리
        PriorityQueue<Road> pq = new PriorityQueue<>((Road o1, Road o2) -> o1.cost - o2.cost);
        pq.add(new Road(1, 0));

        int sum = 0;
        int max = 0;
        while(!pq.isEmpty()) {
            Road now = pq.poll();
            if(visited[now.to]) continue;
            visited[now.to] = true;

            max = Math.max(max, now.cost);
            sum += now.cost;

            for(Road next : roads.get(now.to)) {
                if(visited[next.to] == false) {

                    pq.add(next);
                }
            }

            if(isAllConnected()) break;
        }

        System.out.println(sum - max);
    }

    private static boolean isAllConnected() {
        for(boolean state : visited)
            if(state == false)
                return false;
        return true;
    }
}

class Road {
    int to;
    int cost;

    Road(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}