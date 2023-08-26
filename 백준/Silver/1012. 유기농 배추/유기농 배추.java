import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            count = 0;

            //땅 생성
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][] land = new int[r][c];

            //배추 심기
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                land[x][y] = 1;
            }

            //지렁이 수 세기
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    if(land[i][j]==1) {
                        count++;
                        remove(land, i, j);
                    }
                }
            }

            //결과 출력
            System.out.println(count);
        }
    }

    private static void remove(int[][] land, int x, int y) {
        land[x][y] = 0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<land.length && ny>=0 && ny<land[0].length && land[nx][ny]==1){
                remove(land, nx, ny);
            }
        }
    }
}
