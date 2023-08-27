import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, arr, new boolean[N], 0);

        System.out.println(MIN);
    }

    private static void DFS(int L, int[][] arr, boolean[] picked, int f){
        if(L==arr.length / 2){
            int sumStart = 0, sumLink = 0, index1=0, index2=0;
            int[] start = new int[arr.length/2];
            int[] link = new int[arr.length/2];
            for(int i=0; i<picked.length; i++){
                if(picked[i]) start[index1++] = i;
                else link[index2++] = i;
            }
            for(int i=0; i<start.length-1; i++){
                for(int j=i+1; j<start.length; j++){
                    sumStart += arr[start[i]][start[j]] + arr[start[j]][start[i]];
                    sumLink += arr[link[i]][link[j]] + arr[link[j]][link[i]];
                }
            }
            MIN = MIN > Math.abs(sumStart - sumLink) ? Math.abs(sumStart - sumLink) : MIN;
        }
        for(int i=f; i<arr.length; i++){
            if(!picked[i]){
                picked[i] = true;
                DFS(L+1, arr, picked, i+1);
                picked[i] = false;
            }
        }
    }
}