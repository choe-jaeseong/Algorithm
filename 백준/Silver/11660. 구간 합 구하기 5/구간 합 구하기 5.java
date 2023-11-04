import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //배열 입력
        int[][] arr = new int[N+1][N+1];
        int[][] prefixSum = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(j!=0) prefixSum[i][j] = prefixSum[i][j-1] + arr[i][j];
                else prefixSum[i][j] = arr[i][j];
            }
        }

        //범위 입력 및 결과 출력
        int[] point = new int[4];
        for (int i = 0; i < M; i++) {
            //범위 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                point[j] = Integer.parseInt(st.nextToken());
            }

            //합 구하기
            if (point[0] == point[2] && point[1] == point[3]){
                sb.append(arr[point[0]][point[1]] + "\n");
                continue;
            }

            int sum = 0;
            for(int j=point[0]; j<=point[2]; j++){
                sum += (prefixSum[j][point[3]] - prefixSum[j][point[1] - 1]);
            }

            //결과 출력
            sb.append(sum + "\n");
        }
        System.out.println(sb.toString());
    }
}

/*
아이디어 : DP

1. 누적합 배열을 만든다.
2. (x1, y1) (x2, y2) 사이의 합
= (dp[x1][y2] - dp[x1][y1-1]) + (dp[x2][y2] - dp[x2][y1-1)
 */