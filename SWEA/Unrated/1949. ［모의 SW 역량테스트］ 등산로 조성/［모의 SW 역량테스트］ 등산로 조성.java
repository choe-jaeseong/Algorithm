import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    private static int maxLength = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            maxLength = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            //산 높이 입력
            int[][] mt = new int[N][N];
            int maxHeight = 0;
            ArrayList<int[]> startList = new ArrayList<>();
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    mt[i][j] = Integer.parseInt(st.nextToken());
                    if(maxHeight > mt[i][j]) continue;
                    if(maxHeight < mt[i][j]) {
                        maxHeight = mt[i][j];
                        startList.clear();
                    }
                    startList.add(new int[]{i, j});
                }
            }

            //탐색 시작
            for(int[] start : startList) {
                int[][] visited = new int[N][N];
                visited[start[0]][start[1]] = 1;
                DFS(mt, start, visited, K, 1);
            }

            //결과 출력
            System.out.println("#"+t+" "+maxLength);
        }
    }

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    private static void DFS(int[][] mt, int[] loc, int[][] visited, int k, int length) {
        maxLength = Math.max(maxLength, length);
        for(int i=0; i<4; i++){
            int nx = loc[0] + dx[i];
            int ny = loc[1] + dy[i];
            if(!(nx>=0 && nx<mt.length && ny>=0 && ny<mt.length)) continue;
            if(visited[nx][ny]==1) continue;

            int diff = mt[nx][ny] - mt[loc[0]][loc[1]];
            if(diff < 0) {
                visited[nx][ny] = 1;
                DFS(mt, new int[]{nx, ny}, visited, k, length + 1);
                visited[nx][ny] = 0;
            }
            else if(diff - k < 0) {
                visited[nx][ny] = 1;
                int tmp = mt[nx][ny];
                mt[nx][ny] = mt[loc[0]][loc[1]]-1;
                DFS(mt, new int[]{nx, ny}, visited,0, length + 1);
                mt[nx][ny] = tmp;
                visited[nx][ny] = 0;
            }
        }
    }
}
