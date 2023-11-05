import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //정점의 개수, 간선의 개수
        int V = Integer.parseInt(st.nextToken());   //정점
        int E = Integer.parseInt(st.nextToken());   //간선

        //1. 출발 노드를 설정한다.
        int start = Integer.parseInt(br.readLine());    //시작점

        //방향 그래프 구조 형성
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i=0; i<V+1; i++) list.add(new ArrayList<>());
        //간선 정보 입력
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, cost));
        }

        //다익스트라 알고리즘 수행
        Dijkstra(V, list, start);
    }

    private static void Dijkstra(int n, ArrayList<ArrayList<Node>> list, int start) {
        boolean[] ch = new boolean[n + 1];  //방문체크 배열
        int[] dist = new int[n + 1];        //거리길이 배열
        int INF = Integer.MAX_VALUE;

        //거리길이 배열 초기화
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            //방문하지 않은 노드 중에서 가장 비용이 적은 노드를 선택.
            int nowVtx = pq.poll().index;

            if(ch[nowVtx]) continue;    //방문했으면 넘기기
            ch[nowVtx] = true;

            //출발 노드를 기준으로 각 노드의 최소 비용을 저장한다.
            for(Node next : list.get(nowVtx)){
                //해당 노드를 거쳐서 특정한 노드로 가는 경우를 고려하여 최소 비용을 갱신한다.
                if(dist[next.index] > dist[nowVtx] + next.cost) {
                    dist[next.index] = dist[nowVtx] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        //최소 거리 출력
        for(int i=1; i<dist.length; i++){
            if(dist[i]==INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

}

class Node implements Comparable<Node> {
    int index;
    int cost = Integer.MAX_VALUE;

    public Node(int num, int cost) {
        this.index = num;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

/*
현재까지 알고 있던 최단 경로를 계속해서 갱신한다.

1. 출발 노드를 설정한다.
2. 출발 노드를 기준으로 각 노드의 최소 비용을 저장한다.
3. 방문하지 않은 노드 중에서 가장 비용이 적은 노드를 선택한다.
4. 해당 노드를 거쳐서 특정한 노드로 가는 경우를 고려하여 최소 비용을 갱신한다.
 */