package 고득점kit.Graph.순위;

public class Solution {
    
    public int solution(int n, int[][] results) {
        boolean[][] game =  new boolean[n][n];
        int answer = 0;
        for(int i=0; i<results.length; i++){ game[results[i][0]-1][results[i][1]-1]=true; }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(game[j][i]&&game[i][k]){game[j][k]=true;}
                }
            }
        }
        
        for(int i=0; i<n; i++){
            int result=0;
            for(int j=0; j<n; j++){
                if(game[i][j] || game[j][i]){result++;}
            }
            if(result==n-1){answer++;}
        }
        return answer;
    }
}

/*
 * 1. 인접리스트를 생성하는데, 사이즈가 n-1개이면 확정
 * 2. a->b 일 때, b->c 라면 a->c (플로이드 워셜 알고리즘)
 */