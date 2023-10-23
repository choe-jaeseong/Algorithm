import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num != -1) list.add(num);
        }
        list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list);
//        for(int x : list) System.out.print(x + " ");
//        System.out.println();


        //root node 생성
        Node root = new Node();

        //root node 로부터 값 넣기
        makingTree(root, list, 0, list.size()-1);

        //결과 출력
        printPost(root);
        System.out.println(sb.toString());
//        String answer = sb.toString();
//        System.out.println(answer.substring(0, answer.length()-1));
    }

    private static void printPost(Node root) {

        if(root.left.data != -1) printPost(root.left);
        if(root.right.data != -1) printPost(root.right);
        sb.append(root.data+" ");
    }

    private static Node makingTree(Node root, ArrayList<Integer> list, int start, int end) {
        int midIndex = (start + end) / 2;
        root.data = list.get(midIndex);
        root.left = new Node();
        root.right = new Node();

//        System.out.println(root.data + ": "+start + " | " + (midIndex - 1));
        if(start <= midIndex - 1)
            root.left = makingTree(root.left, list, start, midIndex - 1);

//        System.out.println(root.data + ": "+(midIndex + 1) + " | " + end);
        if(midIndex + 1 <= end)
            root.right = makingTree(root.right, list, midIndex + 1, end);

        return root;
    }
}

class Node {
    int data = -1;
    Node left, right;
    public Node(){}
}