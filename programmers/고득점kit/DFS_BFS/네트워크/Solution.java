package 고득점kit.DFS_BFS.네트워크;


public class Solution {
    int ans;
    int[] ch;
    public int solution(int n, int[][] computers) {
        ans = computers.length;
        ch = new int[n];
        for(int i=0; i<n; i++){
            ch[i]=1;
            for(int j=0; j<n; j++){
                if(ch[j]==0 && computers[i][j]==1){
                    ch[j]=1;
                    ans--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(T.solution(3, arr));
    }
}   

/*
 * 1. i번째 컴퓨터일 때 연결된 컴퓨터가 있다면, 네트워크를 표시하고 전체 개수에서 차감.
 * 2. 
 */