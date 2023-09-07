import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //값 입력받기
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        //센서 정보 입력
        int[] sensors = new int[N];
        for(int i=0; i<N; i++) sensors[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(sensors); //정렬

        //센서 사이 간격 입력
        int[] diff = new int[N-1];
        for(int j=0; j<N-1; j++) diff[j] = sensors[j+1] - sensors[j];
        Arrays.sort(diff); //정렬

        //결과 출력
        int result = 0;
        for(int i=0; i<N - K; i++) result += diff[i];
        System.out.println(result);
    }
}