import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int white = 0, blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(arr, 0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void DFS(int[][] arr, int x, int y, int len) {
        if(isAllSame(arr, x, y, len)){
            if(arr[x][y]==0) white++;
            else blue++;
            return;
        }
        for(int i=x; i<x+len; i+=len/2){
            for(int j=y; j<y+len; j+=len/2){
                DFS(arr, i, j, len/2);
            }
        }
    }

    private static boolean isAllSame(int[][] arr, int x, int y, int len) {
        int target = arr[x][y];
        for(int i=x; i<x+len; i++){
            for(int j=y; j<y+len; j++){
                if(arr[i][j]!=target) return false;
            }
        }
        return true;
    }
}

/*
목표 : 구역을 나눠서 모두 0이거나 모두 1인 종이의 개수를 각각 구하기.
1. 변수 white, blue : 종이 개수
2. 완전 탐색 : DFS
    탈출 조건 = 모두 0이거나 모두 1이면 count 하고 return
    4등분해서 재귀 호출
 */