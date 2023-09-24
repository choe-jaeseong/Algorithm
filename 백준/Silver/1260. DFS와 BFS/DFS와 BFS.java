import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        //간선 정보 입력
        int[][] lines = new int[1001][1001];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            lines[from][to] = 1;
            lines[to][from] = 1;
        }

        //출력
        DFS(V, N, lines, new int[N + 1]);
        System.out.println();
        BFS(V, N, lines);
    }

    private static void BFS(int v, int n, int[][] lines) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        int[] visited = new int[n+1];
        while(!q.isEmpty()){
            int tmp = q.poll();
            if(visited[tmp] == 1) continue;
            System.out.print(tmp + " ");
            visited[tmp] = 1;
            for(int i=1; i<=n; i++){
                if(visited[i]==0 && lines[tmp][i]==1){
                    q.add(i);
                }
            }
        }
    }

    private static void DFS(int v, int n, int[][] lines,int[] visited) {
        System.out.print(v + " ");
        visited[v] = 1;
        for(int i=1; i<=n; i++){
            if(visited[i]==0 && lines[v][i]==1){
                DFS(i, n, lines, visited);
            }
        }
    }
}
