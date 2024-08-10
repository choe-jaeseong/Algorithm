import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n+1][2];
            arr[0][0] = 1;
            if(n >= 1) arr[1][1] = 1;

            for(int i=2; i<=n; i++){
                arr[i][0] = arr[i-1][0] + arr[i-2][0];
                arr[i][1] = arr[i-1][1] + arr[i-2][1];
            }

            System.out.println(arr[n][0] + " " + arr[n][1]);
        }
    }

}
