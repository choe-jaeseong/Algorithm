import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    private static void DFS(int[][] map, int x, int y, ArrayList<Integer> answer, int index){
        map[x][y] = 0;
        answer.set(index, answer.get(index)+1);
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<map.length && ny>=0 && ny <map[0].length && map[nx][ny]==1){
                DFS(map, nx, ny, answer, index);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i=0; i<N; i++){
            char[] s = br.readLine().toCharArray();
            for(int j=0; j<N; j++) map[i][j] = s[j] - '0';
        }

        ArrayList<Integer> answer = new ArrayList<>();
        int remocon = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1){
                    answer.add(0);
                    DFS(map, i, j, answer, remocon);
                    remocon++;
                }
            }
        }
        Collections.sort(answer);

        //정답 출력
        System.out.println(answer.size());
        for(int x : answer) System.out.println(x);
    }
}

/*
1. 전체 순회
2. 해당 셀 == 1 이면, dfs 발동
3. 리모콘 배열에 숫자 증가시키기.
 */