import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Node[] nodes;    //node 배열
    private static int[] Depth;     //start node 를 기준으로 가장 크게 가질 수 있는 깊이 저장.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int power = Integer.parseInt(st.nextToken());

        //트리 형성
        nodes = new Node[N+1];
        Depth = new int[N+1];
        for(int i=0; i<N+1; i++){
            nodes[i] = new Node(i);
        }

        //트리 관계 형성
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].children.add(nodes[b]);
            nodes[b].children.add(nodes[a]);
        }

        //각 노드가 가질 수 있는 깊이 생성
        makingDepth(start);

        //최소 이동 거리
        int move = 0;
        for(int i=1; i<Depth.length; i++){
            if(i!=start && Depth[i] >= power) { //시작점을 제외하고 깊이가 power 이상인 노드의 개수만큼 이동
                move++;
            }
        }
        //결과 출력
        System.out.println(move * 2);
    }

    private static boolean[] ch;
    private static void makingDepth(int start) {
        ch = new boolean[nodes.length];
        ch[start] = true;
        DFS(start);
    }

    private static int DFS(int nodeIndex) {
        int val = 0; //현재 노드의 깊이

        //자식 노드가 있다면, 내 깊이를 갱신.
        for(Node next : nodes[nodeIndex].children){
            if(!ch[next.data]){
                ch[next.data] = true;                   //자식 노드를 방문하고
                val = Math.max(val, DFS(next.data));    //현재 내 노드의 깊이를 저장. (0 또는 자식노드의 최대 깊이 + 1)
            }
        }

        //내 깊이를 저장하고 부모 노드에 깊이 전달.
        Depth[nodeIndex] = val;
//        System.out.println(nodeIndex + ": "+Depth[nodeIndex]);
        return Depth[nodeIndex] + 1;
    }
}



class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();;

    public Node(int data) {
        this.data = data;
    }
}

/*
현재 트리는 양방향 그래프.

1. start node 를 기준으로 leaf 노드로부터 가질 수 있는 최대 깊이를 각 노드번호에 저장.
2. start node 를 제외하고,  각 노드의 깊이가 power 보다 크다면 count + 1
3. 배달을 갔다가 돌아오기 때문에, 결과는 count * 2 로 출력.
 */