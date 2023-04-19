package 고득점kit.완전탐색.전력망을둘로나누기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[][] graph;
    public int BFS(int a, int len){
        int cnt = 0;
        int[] ch = new int[len];
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        while(!q.isEmpty()){
            cnt++;
            int x = q.poll();
            ch[x]=1;
            for(int i=1; i<graph.length; i++){
                if(ch[i]==0 && graph[x][i]==1){
                    ch[i]=1;
                    q.offer(i);
                }
            }
        }
        return cnt;
    }
    public int solution(int n, int[][] wires) {
        int answer = 100;
        graph = new int[n+1][n+1];
        //그래프 그리기
        for(int i=0; i<wires.length; i++){
            graph[wires[i][0]][wires[i][1]]=1;
            graph[wires[i][1]][wires[i][0]]=1;
        }
        //전선 하나를 끊을 경우, 전력량의 차이의 최솟값 구하기
        for(int i=0; i<wires.length; i++){
            graph[wires[i][0]][wires[i][1]]=0;
            graph[wires[i][1]][wires[i][0]]=0;
            int a = BFS(wires[i][0], n+1);
            int b = BFS(wires[i][1], n+1);
            answer = Math.min(answer, Math.abs(a-b));
            graph[wires[i][0]][wires[i][1]]=1;
            graph[wires[i][1]][wires[i][0]]=1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 3;
        int[][] arr = {{1,2},{2,3}};
        System.out.println(T.solution(n, arr));
    }
}
