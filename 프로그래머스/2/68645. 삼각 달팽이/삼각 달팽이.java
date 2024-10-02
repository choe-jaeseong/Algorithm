class Solution {
    public int[] solution(int n) {
        int[][] answer = new int[n][];
        for(int i=1; i<=n; i++) answer[i-1] = new int[i];
        
        int idx = 1;
        int x = 0;
        int y = 0;
        while(true) {
            boolean flag = false;
            //아래
            while(x < answer.length && y < answer[x].length && answer[x][y] == 0) {
                answer[x++][y] = idx++;
                flag = true;
            }
            x--;
            y++;
            //오른쪽
            while(x < answer.length && y < answer[x].length && answer[x][y] == 0) {
                answer[x][y++] = idx++;
                flag = true;
            }
            y-=2;
            x--;
            //대각선위
            while(x >= 0 && y >= 0 && answer[x][y] == 0) {
                answer[x--][y--] = idx++;
                flag = true;
            }
            x+=2;
            y++;
            if(!flag) break;
        }
        int[] result = new int[(1 + n) * n / 2];
        for(int i=0; i<answer.length; i++) {
            for(int j=0; j<answer[i].length; j++) {
                result[i * (i + 1) / 2 + j] = answer[i][j];
            }
        }
        return result;
    }
}