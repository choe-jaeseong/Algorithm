import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) graph.add(new ArrayList<>());

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b,d});
            graph.get(b).add(new int[]{a,d});
        }

        for(int i=0; i<M; i++){
            distance = 0;
            flag = false;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[N+1];
            visited[a] = true;
            getDistance(a, b, graph, visited,0);
            System.out.println(distance);
        }
    }

    private static boolean flag = false;
    private static long distance = 0;
    private static void getDistance(int a, int b, ArrayList<ArrayList<int[]>> graph, boolean[] visited, int sum) {
        if(flag) return;
        if(a == b){
            flag = true;
            distance = sum;
        }

        for(int[] x: graph.get(a)){
            if(visited[x[0]]) continue;
            visited[x[0]] = true;
            getDistance(x[0], b, graph, visited, sum + x[1]);
            visited[x[0]] = false;
        }
    }
}
