import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<Node> graph;
    private static int INF = Integer.MAX_VALUE;
    private static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Node(v, w, cost));
        }

        //BellmanFord 확인 및 결과 출력
        if(BellmanFord(N, M, 1)){  //음의 cycle이 없는 경우
            for(int i=2; i<=N; i++){
                long result = dist[i]==INF ? -1 : dist[i];
                sb.append(result + "\n");
            }
        } else {                        //음의 cycle이 있는 경우
            sb.append(-1 + "\n");
        }
        System.out.println(sb.toString());

        br.close();
    }

    private static boolean BellmanFord(int n, int m, int start) {

        dist = new long[n + 1];

        // 최단거리 초기화
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // 정점 개수만큼 반복
        for (int i = 0; i < n; i++) {
            // 간선 개수만큼 반복
            for (int j = 0; j < m; j++) {
                Node node = graph.get(j); // 현재 간선

                if (dist[node.v] != INF && dist[node.w] > dist[node.v] + node.cost) {
                    dist[node.w] = dist[node.v] + node.cost;
                }
            }
        }

        // 음수 가중치 확인
        for (int i = 0; i < m; i++) {
            Node node = graph.get(i);
            if (dist[node.v] != INF && dist[node.w] > dist[node.v] + node.cost)
                return false;
        }
        return true;
    }
}

class Node {
    int v;
    int w;
    int cost;

    public Node(int v, int w, int cost) {
        this.v = v;
        this.w = w;
        this.cost = cost;
    }
}
