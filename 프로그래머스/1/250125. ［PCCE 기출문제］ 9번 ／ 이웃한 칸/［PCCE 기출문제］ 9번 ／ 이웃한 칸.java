class Solution {
    
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    public int solution(String[][] board, int h, int w) {
        String color = board[h][w];
        int answer = 0;
        for(int i=0; i<4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            if(!(nx>=0 && nx<board.length && ny>=0 && ny<board.length)) continue;
            if(board[nx][ny].equals(color)) answer++;
        }
        return answer;
    }
}