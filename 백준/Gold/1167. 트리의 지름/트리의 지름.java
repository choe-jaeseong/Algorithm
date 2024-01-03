import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        //트리 생성
        tree = new Node[N+1];
        for (int i = 0; i < N+1; i++) tree[i] = new Node(i);

        //트리 간선 형성
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()) {
                int childNum = Integer.parseInt(st.nextToken());
                if(childNum == -1) break;
                int distance = Integer.parseInt(st.nextToken());

                tree[target].children.put(tree[childNum], distance);
            }
        }

        //1번 노드로부터 가장 먼 노드 X를 찾는다.
        longestNum = 0;
        findLongestNodeNum(tree, 1, 0, new boolean[N + 1]);
        int longestNodeNum = longestNum;

        //X로부터 가장 먼 노드를 찾으면서 거리를 계산한다.
        longestNum = 0;
        findLongestNodeNum(tree, longestNodeNum, 0, new boolean[N+1]);

        System.out.println(MAX_DISTANCE);
    }

    private static int longestNum = 0;
    private static int MAX_DISTANCE = 0;
    private static void findLongestNodeNum(Node[] tree, int start, int distance, boolean[] ch) {
        if(MAX_DISTANCE < distance) {
            MAX_DISTANCE = distance;
            longestNum = start;
        }

        ch[start] = true;

        for(Node node : tree[start].children.keySet()) {
            if(ch[node.data]) continue;

            findLongestNodeNum(tree, node.data, distance + tree[start].children.get(node), ch);
        }
    }

    static class Node {
        int data;
        Map<Node, Integer> children = new HashMap<>();  // node, distance

        public Node(int data) {
            this.data = data;
        }
    }
}