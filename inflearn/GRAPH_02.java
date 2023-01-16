//13. 경로탐색(12번과 동일. 연결리스트)
import java.util.ArrayList;
import java.util.Scanner;

public class GRAPH_02 {
    static int n, m, ans=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    public void DFS(int v){
        if(v==n) ans++;
        else {
            for(int nv : graph.get(v)){
                if(visited[nv]==0){
                    visited[nv]=1;
                    DFS(nv);
                    visited[nv]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        GRAPH_02 T = new GRAPH_02();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());    //객체생성 필수!
        }
        visited= new int[n+1];
        for(int i=0; i<m; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph.get(a).add(b);    //a번 ArrayList 에 접근
        }
        visited[1]=1;
        T.DFS(1);
        System.out.println(ans);
        sc.close();
    }
}
