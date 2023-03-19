package DFS_BFS;
//14.그래프 최단거리(BFS)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GRAPH_03 {
    static int n, m;
    static int[] visited, dis;
    static ArrayList<ArrayList<Integer>> graph;
    public void BFS(int k){
        Queue<Integer> Q = new LinkedList<>();
        visited[k] = 1;
        dis[k]=0;
        Q.offer(k);
        while(!Q.isEmpty()){
            int x = Q.poll();
            for(int nx: graph.get(x)){
                if(visited[nx]==0) {
                    visited[nx]=1;
                    Q.offer(nx);
                    dis[nx]=dis[x]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        GRAPH_03 T = new GRAPH_03();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        visited = new int[n+1];
        dis = new int[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i+" : " + dis[i]);
        }
        sc.close();
    }
}
