import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    private static void DFS(int[][] land, int x, int y, int h){
        land[x][y] = 0;
        for(int k=0; k<4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx>=0 && nx<land.length && ny>=0 && ny<land.length && land[nx][ny] > h){
                DFS(land, nx, ny, h);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        //1. 지도 정보 입력
        int[][] land = new int[N][N];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                land[i][j] = Integer.parseInt(st.nextToken());
                if(land[i][j] < min) min = land[i][j];
                if(land[i][j] > max) max = land[i][j];
            }
        }

        //2. 안전지역 최댓값 구하기
        int countMax = 0;
        for(int h=min-1; h<=max; h++){
            int[][] land1 = new int[N][N];
            for(int i=0; i<N; i++) land1[i] = land[i].clone();
            int count = 0;
            for(int i=0; i<land.length; i++){
                for(int j=0; j<land[0].length; j++){
                    if(land1[i][j]>h){
                        count++;
                        DFS(land1, i, j, h);
                    }
                }
            }
            countMax = Math.max(count, countMax);
        }

        //3. 최댓값 출력
        System.out.println(countMax);

        br.close();
    }
}

/*
1. 지역 높이 정보 입력. 최대값과 최소값 체크.
2. 침수 높이별 안전구역 개수 세서 최대값 구하기.
 */