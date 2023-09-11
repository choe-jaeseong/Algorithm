import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] holes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) holes[i] = Integer.parseInt(st.nextToken());

        //투포인터 초기값 설정
        int answer = 0; //MAX
        int lp = 0, rp = 0;
        int sum = holes[0];
        while(rp < N){
            if(sum <= M) {
                answer = Math.max(answer, sum);
                rp++;
                sum = rp < N ? sum + holes[rp] : sum;
            } else if (lp < rp){  //sum > M 일 때,
                sum -= holes[lp];
                lp++;
            } else {
                rp++;
                sum = rp < N ? sum + holes[rp] : sum;
            }
        }

        //결과 출력
        System.out.println(answer);
    }
}
