import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    private static int total = 0;
    private static int removed = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] arr = new int[r][c];
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) total++;
            }
        }

//        for(int i=0; i<r; i++){
//            for(int j=0; j<c; j++) System.out.print(arr[i][j]);
//            System.out.println();
//        }

        int taken = 0;
        while(total - removed > 0){
            total -= removed;
            changeCornor(arr, new int[r][c],0, 0);
            removed = removeCornor(arr);
            taken++;
//            System.out.println("taken: "+taken+", total: "+total+", removed: "+removed);
        }
        System.out.println(taken);
        System.out.println(total);

    }
    private static void changeCornor(int[][] arr, int[][] visited, int x, int y) {
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length)) continue;
            if(arr[nx][ny]==1) arr[nx][ny] = 2;
            if(visited[nx][ny]==0 && arr[nx][ny]==0) {
                visited[nx][ny] = 1;
                changeCornor(arr, visited, nx, ny);
            }
        }
    }
    private static int removeCornor(int[][] arr) {
        int count = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==2){
                    count++;
                    arr[i][j]=0;
                }
            }
        }
        return count;
    }
}

/*
1. 치즈를 배열에 놓는다. 치즈 개수를 센다.
2. 치즈 녹이기
    DFS로 겉부분을 2로 바꾼다.
    2로 적힌 부분을 제거한다.
    제거한 치즈 수 세기.
 */
