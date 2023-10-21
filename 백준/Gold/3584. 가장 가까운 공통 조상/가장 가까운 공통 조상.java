import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++){
            //노드 개수
            int N = Integer.parseInt(br.readLine());

            //노드 배열 생성
            Node[] arr = new Node[N + 1];
            for(int i=0; i<N+1; i++) arr[i] = new Node(i, null, new ArrayList<>());

            //노드 관계 형성
            for(int i=0; i<N-1; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a].children.add(arr[b]);
                arr[b].parent = arr[a];
            }

            //타겟 노드 생성
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //타겟 노드의 부모 리스트 생성
            ArrayList<Node> listA = findParents(arr[a]);
//            for(Node x : listA) System.out.print(x.num + " ");
            ArrayList<Node> listB = findParents(arr[b]);
//            for(Node x : listB) System.out.print(x.num + " ");

            //가장 가까운 부모 찾기
            int nearParent = findNearParent(listA, listB);

            System.out.println(nearParent);
        }
    }

    private static int findNearParent(ArrayList<Node> listA, ArrayList<Node> listB) {
        int parent = 0;
        int L = Integer.MAX_VALUE;
        for(int i=0; i<listB.size(); i++){
            for(int j=0; j<listA.size(); j++){
                if(listB.get(i).num == listA.get(j).num){
                    if(j < L){
                        L = j;
                        parent = listA.get(j).num;
                    }
                }
            }
        }
        return parent;
    }

    private static ArrayList<Node> findParents(Node node) {
        ArrayList<Node> parents = new ArrayList<>();
        parents.add(node);
        while(node.parent != null){
            parents.add(node.parent);
            node = node.parent;
        }
        return parents;
    }
}

class Node {
    int num;
    Node parent;
    ArrayList<Node> children;

    public Node(int num, Node parent) {
        this.num = num;
        this.parent = parent;
    }

    public Node(int num, Node parent, ArrayList<Node> children) {
        this.num = num;
        this.parent = parent;
        this.children = children;
    }
}

/*
1. 트리를 구성한다. (노드 배열 + 트리 구조)
2. 각 노드의 조상 배열을 생성해서 공통 되는 것 중 첫 번째 노드를 선택한다.
 */