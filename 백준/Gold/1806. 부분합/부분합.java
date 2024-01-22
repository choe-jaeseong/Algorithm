import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int p1=0, p2=0, sum=arr[0], len=1;
        while(p2 < N) {
            //갱신
            if(sum >= S) answer = Math.min(answer, len);

            //포인터 옮기기
            if(p1 == p2) {
                if(p2 == N-1) break;
                p2++;
                len++;
                sum += arr[p2];
            } else if (sum < S) {
                if(p2 == N-1) break;
                p2++;
                len++;
                sum += arr[p2];
            } else if (sum >= S) {
                sum -= arr[p1++];
                len--;
            }
        }

        if(answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}