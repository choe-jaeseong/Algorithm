import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =  Integer.parseInt(st.nextToken());
        int K =  Integer.parseInt(st.nextToken());

        if(N==K) {
            System.out.println(0);
            return;
        }

        BFS(N, K);
    }

    private static void BFS(int n, int k) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(n);
        int[] ch = new int[100001];
        ch[n] = 1;
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            if(tmp==k) {
                System.out.println(ch[tmp] - 1);
                return;
            }
            if(tmp*2 >= 0 && tmp*2 < 100001 && ch[tmp*2]==0){
                ch[tmp*2] = ch[tmp] + 1;
                Q.add(tmp*2);
            }
            if(tmp+1 >= 0 && tmp+1 < 100001 && ch[tmp+1]==0) {
                ch[tmp+1] = ch[tmp] + 1;
                Q.add(tmp+1);
            }
            if(tmp-1 >= 0 && tmp-1 < 100001 && ch[tmp-1]==0) {
                ch[tmp-1] = ch[tmp] + 1;
                Q.add(tmp-1);
            }
        }
    }
}
