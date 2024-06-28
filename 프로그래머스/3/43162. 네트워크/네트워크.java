class Solution {
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
}