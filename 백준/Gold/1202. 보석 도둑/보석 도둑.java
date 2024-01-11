import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N: 보석 수, K: 가방 수
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] gems = new int[N][3];   //0: 무게, 1: 가격, 2: 방문체크
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            gems[i][0] = Integer.parseInt(st.nextToken());
            gems[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bags = new int[K];
        for(int i=0; i<K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        //보석 정렬 (1. 무게, 2. 값)
        Arrays.sort(gems, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        //가방 정렬
        Arrays.sort(bags);

        // 우선순위 큐는 항상 가격이 내림차순 정렬되도록 설정.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sumPrice = 0;
        for (int i = 0, j = 0; i < K; i++) {
            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음.
            while (j < N && gems[j][0] <= bags[i]) {
                pq.offer(gems[j++][1]);
            }

            // 우선순위 큐에 있는 요소를 하나 빼서 가방에 넣음.
            // 이 때, 우선순위 큐는 내림차순 정렬이 되어있으므로
            // 첫 번째 요소는 가장 큰 가격을 의미함.
            if (!pq.isEmpty()) {
                sumPrice += pq.poll();
            }
        }

        System.out.println(sumPrice);
    }
}