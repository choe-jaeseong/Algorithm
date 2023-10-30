import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //진입차수 배열
        int[] inDegree = new int[N+1];

        //그래프 구조 형성
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<N+1; i++) list.add(new ArrayList<>());

        //그래프 관계 형성
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b); //그래프 관계 형성
            inDegree[b]++;      //진입차수 증가
        }

        //위상 정렬
        int[] result = topologySort(list, inDegree);

        //결과 출력
        for(int i=1; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }

    private static int[] topologySort(ArrayList<ArrayList<Integer>> list, int[] inDegree) {
        int[] result = new int[list.size()];
        Queue<Integer> Q = new LinkedList<>();

        //진입차수 0인 지점 넣기
        for(int i=1; i<inDegree.length; i++){
            if(inDegree[i]==0){
                Q.add(i);
            }
        }

        //정점 n 개만 출력
        for(int i=1; i<list.size(); i++){
            //정점을 다 돌기 전에, 큐가 비어있으면, 사이클 존재.
            if(Q.isEmpty()) return new int[]{-1,-1};

            int tmp = Q.poll();
            result[i] = tmp;
            for(int x : list.get(tmp)){
                inDegree[x]--;
                if(inDegree[x]==0){
                    Q.add(x);
                }
            }
        }

        return result;
    }

}
