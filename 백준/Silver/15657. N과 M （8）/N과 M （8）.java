import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        DFS(arr, M, 0, 0, new int[M]);
    }

    private static void DFS(int[] arr, int m, int L, int start, int[] result) {
        if(L == m){
            for(int x : result)
                System.out.print(x + " ");
            System.out.println();
            return;
        }
        for(int i=start; i<arr.length; i++){
            result[L] = arr[i];
            DFS(arr, m, L+1, i, result);
        }
    }

}
