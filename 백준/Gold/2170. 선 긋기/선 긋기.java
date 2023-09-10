import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[i][0] = from;
            arr[i][1] = to;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0]==o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int answer = 0;
        int start = arr[0][0];
        int end = arr[0][1];
        int i = 1;
        while(i < N){
            if(arr[i][0] <= end) {
                end = Math.max(end, arr[i][1]);
            }
            else {
                answer += end - start;
                start = arr[i][0];
                end = arr[i][1];
            }
            i++;
        }
        answer += end - start;
        System.out.println(answer);
    }
}
