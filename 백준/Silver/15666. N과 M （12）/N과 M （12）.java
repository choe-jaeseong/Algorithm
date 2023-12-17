import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N과 M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //N 개의 수열 입력
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //수열 오름차순 정렬
        Arrays.sort(arr);

        //조합 생성
        makingSet(0, M, 0, new int[M]);

        //결과 출력
        System.out.println(sb.toString());
    }

    private static void makingSet(int L, int M, int startIdx, int[] set) {
        if(L==M){
            for(int x : set) sb.append(x + " ");
            sb.append("\n");
            return;
        }
        int prev = 0;
        for(int i = startIdx; i < arr.length; i++) {
            if(prev == arr[i]) continue;
            set[L] = arr[i];
            prev = arr[i];
            makingSet(L + 1, M, i, set);
        }
    }
}
/*
1. N 과 M 을 입력받는다.
2. N 개의 숫자를 입력받는다.
3. M 개의 숫자로된 조합을 생성한다. (backtracking)
    각 레벨에서 중복인 경우는 건너뛴다.

 */