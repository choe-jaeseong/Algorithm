import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] knowns = new boolean[51];
    private static List<List<Integer>> parties = new ArrayList<>();
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //사람의 수, 파티의 수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //union 에 사용되는 parents 초기화
        parents = new int[N+1];
        for (int i = 1; i <=N ; i++) parents[i] = i;

        //진실을 아는 사람
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            knowns[Integer.parseInt(st.nextToken())] = true;
        }

        if(n == 0) {
            System.out.println(M);
            return;
        }

        //파티 멤버 등록 및 union
        for (int i = 0; i < M; i++) {
            parties.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            int pre = Integer.parseInt(st.nextToken());
            parties.get(i).add(pre);
            
            for (int j = 1; j < n; j++) {
                int member = Integer.parseInt(st.nextToken());
                parties.get(i).add(member);
                union(pre, member);
            }
        }

        //진실을 아는 사람들 정리
        for (int i = 0; i < knowns.length; i++)
            if(knowns[i])
                knowns[find(i)] = true;

        //과장된 이야기를 할 수 있는 파티 개수의 최댓값 세기
        int total = 0;
        for (int i = 0; i < M; i++) {
            int parent = find(parties.get(i).get(0));
            if(!knowns[parent]) total++;
        }
        System.out.println(total);
    }

    private static int find(int v) {
        int parent = parents[v];
        if(parent == v) return v;

        return find(parent);
    }

    private static void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if(p1 == p2) return;

        parents[p2] = p1;
    }
}