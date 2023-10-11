import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 회의 정보 입력
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 회의 시간 정렬
        Arrays.sort(arr, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);

        // 개수 세기
        int count = 1;
        int end = arr[0][1];
        for(int i=1; i<N; i++){
            if(arr[i][0] >= end) {
                end = arr[i][1];
                count++;
            }
        }

        //결과 출력
        System.out.println(count);
    }
}
