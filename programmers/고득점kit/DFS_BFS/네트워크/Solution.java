package 고득점kit.DFS_BFS.네트워크;
/*
 * 1. computer 배열을 순환
 * 2. if : i번째 숫자가 ch[i]==0 이면
 *      ch[i] = 1; 네트워크 숫자 +1 증가;
 *      for : 다른 컴퓨터들 순환 
 *          if i==j 이면 continue;
 *          i!=j 일때, j 컴퓨터가 다른 네트워크에 연결된 적이 없고, i컴퓨터와 연결되어있다면
 *          DFS(j);
 * 
 * */


public class Solution {
    int[] ch;
    int answer = 0;
    public void DFS(int x, int[][] computers){
        if(ch[x]==1) return ;
        else{
            ch[x]=1;
            for(int i=0; i<ch.length; i++){
                if(ch[i]==0 && computers[x][i]==1){
                    DFS(i, computers);
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        ch = new int[n];
        for(int i=0; i<n; i++){
            if(ch[i]==0){
                answer++; //네트워크 수 1 증가.
                DFS(i, computers);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr = {{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(T.solution(3, arr));
    }
}   
