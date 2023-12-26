import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //키 등록
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        //개수 세기
        int count = 0;
        for (int i = 0; i < M; i++) {
            int result = map.getOrDefault(br.readLine(), 0);
            if(result == 1) count++;
        }

        System.out.println(count);
    }
}
