import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            long sum = 0;

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long[] stocks = new long[N];
            for(int i=0; i<N; i++) stocks[i] = Integer.parseInt(st.nextToken());

            long max = 0;
            for(int i=N-1; i>=0; i--){
                if(stocks[i] > max) {
                    max = stocks[i];
                } else {
                    sum += max - stocks[i];
                }
            }

            System.out.println(sum);
        }

    }
}
