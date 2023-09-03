import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] budgets = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) budgets[i] = Long.parseLong(st.nextToken());
        long totalBudgets = Long.parseLong(br.readLine());

        Arrays.sort(budgets);
        long start = 1, end = budgets[budgets.length-1] + 1;
        while(start < end){
            long mid = (start + end) / 2;

            int count = 0;
            for(long budget : budgets) count += budget <= mid ? budget : mid;

            if(count > totalBudgets) end = mid;
            else start = mid + 1;
        }
        System.out.println(start - 1);
    }
}
/*
분할 정복
정답 = 가능한 최대의 예산
1. 예산요청 입력, 총예산 입력
2. 분할 정복 시작
    - 최대 예산을 측정(mid)
    - 최대 예산에 맞춰서 지급을 했을 때, 총예산으로 가능한지 확인.
 */