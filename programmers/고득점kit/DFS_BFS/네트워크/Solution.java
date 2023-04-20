package 고득점kit.DFS_BFS.네트워크;

public class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(computers[i][j]==1 && computers[j][k]==1){
                        computers[i][k]=1;
                        computers[k][i]=1;
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(computers[i][j]+" ");
            }
            System.out.println();
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(T.solution(3, arr));
    }
}   
