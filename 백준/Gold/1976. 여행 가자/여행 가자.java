import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<Integer> parents = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //도시의 수와 여행 도시의 수 입력
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) parents.add(i);  //도시 연결 초기화

        //지도 입력
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    union(i, j);        //도시 연결
                }
            }
        }
        //여행 루트 입력
        int[] plan = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) plan[i] = Integer.parseInt(st.nextToken());

        //연결되어 있는지 확인
        for(int i=0; i<plan.length-1; i++) {
            int p1 = find(plan[i] - 1);
            int p2 = find(plan[i+1] - 1);

            if(p1 != p2) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if(p1 == p2) return;

        parents.set(p2, p1);
    }

    private static int find(int v) {
        int parent = parents.get(v);
        if(parent == v) return v;

        return find(parent);
    }
}