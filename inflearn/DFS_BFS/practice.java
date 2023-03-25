package DFS_BFS;
//12. 경로탐색(DFS, 인접행렬)
import java.util.Scanner;

public class practice {
    static int n, m;
    static int answer = 0;
    static int[] ch;        //방문기록
    static int[][] graph;   //경로
    public void DFS(int v){
        if(v==n) answer++;
        else {
            for(int i=1; i<=n; i++){
                if(graph[v][i]==1 && ch[i]==0){ //경로가 있고, 방문한 적이 없다면
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        practice T = new practice();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //노드 수
        m = sc.nextInt(); //경로 수
        ch = new int[n+1];
        graph = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            int p = sc.nextInt();
            int q = sc.nextInt();
            graph[p][q] = 1;
        }
        ch[1]=1;   //표시하고 시작하기.
        T.DFS(1);
        System.out.println(answer);
        sc.close();
    }
}
