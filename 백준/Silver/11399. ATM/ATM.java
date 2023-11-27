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

        st = new StringTokenizer(br.readLine());
        int[] taken = new int[N];
        for(int i=0; i<N; i++){
            taken[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(taken);

        int totalSum = 0;
        int indivisualSum = 0;
        for(int x : taken){
            indivisualSum += x;
            totalSum += indivisualSum;
        }

        System.out.println(totalSum);
    }
}
