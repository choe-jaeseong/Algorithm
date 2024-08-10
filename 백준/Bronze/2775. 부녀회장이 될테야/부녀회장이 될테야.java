import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            int[][] apart = new int[a + 1][b + 1];
            for(int i=1; i<=b; i++) {
                apart[0][i] = i;
            }

            for(int i=1; i<=a; i++) {
                apart[i][1] = apart[i-1][1];
                for(int j=2; j<=b; j++) {
                    apart[i][j] = apart[i][j - 1] + apart[i - 1][j];
                }
            }

            System.out.println(apart[a][b]);
        }
    }
}
