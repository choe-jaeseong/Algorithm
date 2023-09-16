import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        arr[1] = 0;

        //DP : Bottom-up
        for(int i=2; i<=N; i++){
            arr[i] = DP(i, arr);
        }

        //결과 출력
        System.out.println(arr[N]);
    }

    private static int DP(int i, int[] arr) {
        if(i%3==0 && i%2==0){
            return Math.min(Math.min(arr[i/3], arr[i/2]), arr[i-1]) + 1;
        } else if (i%3==0){
            return Math.min(arr[i/3], arr[i-1]) + 1;
        } else if (i%2==0){
            return Math.min(arr[i/2], arr[i-1]) + 1;
        } else {
            return arr[i-1] + 1;
        }
    }
}

/*
DP 접근
1부터 N까지 접근하여 최소 횟수를 찾는다.
dp[n+1] = Math.min(방법1(n+1) + 방법2(n+1) + 방법3(n+1))
 */