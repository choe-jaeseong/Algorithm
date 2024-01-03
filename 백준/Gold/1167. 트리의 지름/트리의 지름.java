import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<int[]>> tree;
    private static boolean[] ch;
    private static int selected;
    private static int MAX_DISTANCE = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        //트리 생성
        tree = new ArrayList<>();
        for (int i = 0; i < N+1; i++) tree.add(new ArrayList<>());

        //트리 간선 형성
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()) {
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int distance = Integer.parseInt(st.nextToken());

                tree.get(from).add(new int[]{to, distance});
            }
        }

        //1번 노드로부터 가장 먼 노드 X를 찾는다.
        ch = new boolean[N+1];
        findLongestNodeNum(1, 0);

        //X로부터 가장 먼 노드를 찾으면서 거리를 계산한다.
        ch = new boolean[N+1];
        findLongestNodeNum(selected, 0);

        System.out.println(MAX_DISTANCE);
    }

    private static void findLongestNodeNum(int start, int distance) {
        if(MAX_DISTANCE < distance) {
            MAX_DISTANCE = distance;
            selected = start;
        }

        ch[start] = true;

        for(int[] node : tree.get(start)) {
            if(ch[node[0]]) continue;

            findLongestNodeNum(node[0], distance + node[1]);
        }
    }
}