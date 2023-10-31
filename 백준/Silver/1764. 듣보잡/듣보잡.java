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

        //듣도 못한 사람
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        //보도 못한 사람
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<M; i++){
            String now = br.readLine();
            if(set.contains(now)) list.add(now);
        }

        Collections.sort(list);

        //결과 출력
        System.out.println(list.size());
        for(String x : list) System.out.println(x);
    }
}
