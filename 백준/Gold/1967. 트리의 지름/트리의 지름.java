import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        //tree 구조 생성
        ArrayList<ArrayList<int[]>> tree = new ArrayList<>();
        for(int i=0; i<N+1; i++) tree.add(new ArrayList<>());

        //tree 값 입력
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            tree.get(a).add(new int[]{b, d});
            tree.get(b).add(new int[]{a, d});
        }

        //tree 끝점 두 번 찾기
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        int a = findLongestEndPoint(tree, visited,1, 0);

        visited = new boolean[N+1];
        visited[a] = true;
        int b = findLongestEndPoint(tree, visited, a, 0);
        
        //결과 출력
        System.out.println(distance);
    }

    private static int distance = 0;
    private static int Nodenum = 1;
    private static int findLongestEndPoint(ArrayList<ArrayList<int[]>> tree, boolean[] visited, int start, int sum) {
        if(sum > distance){
            distance = sum;
            Nodenum = start;
        }
        for(int[] x : tree.get(start)){
            if(visited[x[0]]) continue;
            visited[x[0]] = true;
            findLongestEndPoint(tree, visited, x[0], sum + x[1]);
            visited[x[0]] = false;
        }
        return Nodenum;
    }
}

