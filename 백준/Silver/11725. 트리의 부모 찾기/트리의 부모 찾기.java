import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i=0; i<=N; i++)
            tree.add(new ArrayList<>());

        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        //정답 배열
        int[] arr = new int[N + 1];
        arr[1] = 1;

        //탐색
        DFS(arr, tree, 1);

        //결과 출력
        for(int i=2; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }

    private static void DFS(int[] arr, ArrayList<ArrayList<Integer>> tree, int L) {
        for(int x : tree.get(L)){
            if(arr[x] != 0) continue;
            arr[x] = L;
            DFS(arr, tree, x);
        }
    }

}
/*
1. Arraylist로 graph 를 구현한다.
2. root인 1부터 차례로 탐색하면서 각 노드의 root를 지정한다.
 */