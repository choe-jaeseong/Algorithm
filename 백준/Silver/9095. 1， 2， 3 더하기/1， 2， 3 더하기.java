import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            count = 0;
            int n = Integer.parseInt(br.readLine());
            DFS(0, n);
            System.out.println(count);
        }
    }

    private static void DFS(int sum, int n) {
        if(sum > n) return;
        if(sum == n) {
            count++;
            return;
        }
        for(int i=1; i<=3; i++) {
            DFS(sum + i, n);
        }
    }
}