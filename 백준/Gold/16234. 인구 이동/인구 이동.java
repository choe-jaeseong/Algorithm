import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    private static int[][] land;
    private static boolean[][] isvisited, used;
    private static int lower, upper, sum, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        lower = Integer.parseInt(st.nextToken());
        upper = Integer.parseInt(st.nextToken());

        //인구 입력
        land = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //반복문 시작
        boolean isPossible = true;
        int movement = 0;
        while(isPossible){
            isPossible = false;
            isvisited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!isvisited[i][j]){
                        isvisited[i][j] = true;
                        used = new boolean[N][N];
                        sum = 0; count = 0;
                        check(i, j);
                        if(count>1) {
                            isPossible = true;
                            move(i, j);
                        }
                    }
                }
            }
            if(isPossible) movement++;
        }
        System.out.println(movement);
    }

    private static void check(int x, int y){
        sum += land[x][y];
        count++;
        used[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<land.length && ny>=0 && ny<land.length && !isvisited[nx][ny] && Math.abs(land[x][y] - land[nx][ny]) >= lower && Math.abs(land[x][y] - land[nx][ny]) <= upper){
                isvisited[nx][ny] = true;
                check(nx, ny);
            }
        }
    }
    private static void move(int x, int y){
        land[x][y] = sum / count;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<land.length && ny>=0 && ny<land.length && used[nx][ny]){
                used[nx][ny] = false;
                move(nx, ny);
            }
        }
    }
}
/*

1. 배열 크기 입력받고, 인구차이 최대,최소 입력받기
    배열 생성해서 인구 수 입력받기
2. 반복문 시작 (인구이동 횟수가 증가했다면,)
    현재 인구이동 횟수 = 인구이동횟수
    . 국경선 열릴 수 있는지 확인하기. 해당 위치와 그리고 sum 과 count 세기
    . 열릴 수 있는지 확인된 부분에 값 갱신하기.
    . 인구이동 횟수 증가하기.

 */