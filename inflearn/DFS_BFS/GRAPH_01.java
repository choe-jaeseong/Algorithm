package DFS_BFS;
//12. 경로탐색(DFS, 인접행렬)
import java.util.Scanner;

public class GRAPH_01 {
    static int n, m;
    static int[] visited;   //방문기록
    static int[][] graph;   //경로
    static int ans = 0;
    public void DFS(int k){
        if(k==5) ans++;
        else {
            for(int i=1; i<=n; i++){
                if(graph[k][i]==1 && visited[i]==0) { //경로가 있고, 방문한 적이 없을때
                    visited[i]=1;   
                    DFS(i);
                    visited[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        GRAPH_01 T = new GRAPH_01();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //노드 수
        m = sc.nextInt();   //경로 수
        visited = new int[n+1];
        graph = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            int p = sc.nextInt();
            int q = sc.nextInt();
            graph[p][q]=1;
        }
        visited[1]=1;  //방문기록 체크하고 시작하기.
        T.DFS(1);
        System.out.println(ans);
        sc.close();
    }
}
