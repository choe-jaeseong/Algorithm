import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
class Solution {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int[] ch;
    int max_L;
    public void BFS(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        ch[1]=1;
        while(!q.isEmpty()){
            int y=q.poll();
            for(int i : graph.get(y)){
                if(ch[i]==0){
                    ch[i]=ch[y]+1;
                    max_L = Math.max(max_L, ch[i]);
                    q.offer(i);
                }
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ch = new int[n+1];
        for(int i=0; i<=n; i++){
            graph.add(i, new ArrayList<>());
        }
        //그래프 그리기
        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        //최단거리 탐색.
        BFS(1);
        for(int i=2; i<=n; i++){
            if(ch[i]==max_L) {
                answer++;
            }
        }
        return answer;
    }
}