import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int N, M, totalSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        totalSum = 0;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalSum += arr[i];
        }

        //최소 점수를 몇으로 해야하나?
        int lo = 0;
        int hi = totalSum;
        while(lo <= hi) {
            int mid = (lo + hi) / 2; //mid = 최소점수

            int sum = 0;
            int cnt = 0;
            for(int i=0; i<N; i++) {
                sum += arr[i];
                if(sum >= mid) {
                    cnt++;
                    sum = 0;
                }
            }
            if(cnt >= M) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(lo - 1);
    }
}
/*
최솟값의 최댓값 upper bound
 */