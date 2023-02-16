package Level0.안전지대;

public class Solution {
    public void marking_board(int[][] board, int n, int i, int j){
        int[] dx = {-1,0,1,-1,1,-1,0,1};
        int[] dy = {-1,-1,-1,0,0,1,1,1};
        for(int p=0; p<8; p++){
            int nx = i + dx[p];
            int ny = j + dy[p];
            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==0)
                board[nx][ny]=2;
        }

    }

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1){
                    marking_board(board, n, i, j);
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(board[i][j]);
                if(board[i][j]==0) answer++;
            }
            System.out.println();
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] board = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,1,1,0},{0,0,0,0,0}};
        System.out.println(T.solution(board));
    }
}
