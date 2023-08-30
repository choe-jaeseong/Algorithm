import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    private static int[] counts, visited;
    private static int MAX = Integer.MIN_VALUE;
    private static ArrayList<Integer> answer = new ArrayList<>();
    private static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //신뢰 관계 입력
        counts = new int[N];
        for(int i=0; i<N; i++) map.put(i, new ArrayList<>());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            map.get(from).add(to);
        }

        for(int i=0; i<N; i++) {
            visited =  new int[N];
            visited[i] = 1;
            DFS(i);
        }

        for(int i=0; i<N; i++){
            if(counts[i]==MAX)
                answer.add(i);
        }

        //결과 출력
        for(int x : answer) System.out.print(x+1 + " ");
    }

    private static void DFS(int now){
        for(int next : map.get(now)){
            if(visited[next] == 0){
                counts[next]++;
                MAX = MAX < counts[next] ? counts[next] : MAX;
                visited[next] = 1;
                DFS(next);
            }
        }
    }
}

/*
1. 신뢰 관계를 입력한다. (from -> to)
2. 각 컴퓨터에서 가질수 있는 신뢰 관계 개수를 파악해서, answer 에 갱신
 */