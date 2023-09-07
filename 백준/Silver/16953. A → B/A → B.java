import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        boolean flag = BFS(A, B);

        if(flag) System.out.println(count);
        else System.out.println(-1);
    }

    private static boolean BFS(long a, long b) {
        Queue<Long[]> q = new LinkedList<>();
        q.add(new Long[]{a,1L});

        while(!q.isEmpty()) {
            Long[] tmp = q.poll();
            if(tmp[0] == b) {count = tmp[1]; return true;}
            if(tmp[0] > b) continue;

            q.add(new Long[]{tmp[0] * 2, tmp[1]+1});
            q.add(new Long[]{tmp[0] * 10 + 1, tmp[1]+1});
        }
        return false;
    }
}
