import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] arr = new int[10001];
    private static ArrayList<Integer> list;
    private static StringBuilder sb = new StringBuilder();;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        //요소값 저장
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            arr[a]++;
            set.add(a);
        }

        //set -> List
        list = new ArrayList<>(set);

        //정렬
        Collections.sort(list);

        //출력
        printSet(0, M, new int[M]);
        System.out.println(sb.toString());
    }

    private static void printSet(int L, int M, int[] answer) {
        if(L == M) {
            for(int x : answer) sb.append(x + " ");
            sb.append("\n");
            return;
        }
        for(int i=0; i<list.size(); i++){
            if(arr[list.get(i)] > 0) {
                arr[list.get(i)]--;
                answer[L] = list.get(i);
                printSet(L + 1, M, answer);
                arr[list.get(i)]++;
            }
        }
    }
}
