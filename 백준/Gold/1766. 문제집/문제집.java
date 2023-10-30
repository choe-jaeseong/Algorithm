import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            list.get(a).add(b);
            inDegree[b]++;
        }

        //위상 정렬
        int[] result = topologySort(list, inDegree);

        //결과 출력
        for(int i=1; i<result.length; i++) System.out.print(result[i]+" ");
    }

    private static int[] topologySort(ArrayList<ArrayList<Integer>> list, int[] inDegree) {
        int[] result = new int[list.size()];
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        //진입차수가 0인 지점을 Q 에 넣기
        for(int i=1; i<inDegree.length; i++)
            if(inDegree[i]==0)
                Q.add(i);

        //n개의 정점을 선택
        for(int i=1; i<list.size(); i++){
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
