import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] ch_DFS, ch_BFS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(ArrayList list : graph)
            Collections.sort(list);

        ch_DFS = new boolean[N+1];
        ch_BFS = new boolean[N+1];

        DFS(V);
        System.out.println();
        BFS(V);
    }

    static void DFS(int start) {
        if(ch_DFS[start] == true) return;
        ch_DFS[start] = true;

        System.out.print(start + " ");

        for(int next : graph.get(start))
            if(ch_DFS[next] == false)
                DFS(next);
    }

    static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int now = q.poll();

            if(ch_BFS[now] == true) continue;
            ch_BFS[now] = true;

            System.out.print(now + " ");

            for(int next : graph.get(now)) {
                if(ch_BFS[next] == false) {
                    q.add(next);
                }
            }
        }
    }
}
