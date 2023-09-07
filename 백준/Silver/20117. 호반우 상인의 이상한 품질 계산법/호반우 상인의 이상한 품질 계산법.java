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
        int[] qualities = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) qualities[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(qualities);

        int result = 0;
        for(int i=0; i<N/2; i++) result += qualities[N-1-i] * 2;
        if(N%2==1) result += qualities[N-1-N/2];

        System.out.println(result);
    }
}
