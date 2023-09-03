import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long lp = 1, rp = 0, mp;
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] lines = new long[k];
        for(int i=0; i<k; i++) {
            lines[i] = Long.parseLong(br.readLine());
            rp = Math.max(rp, lines[i]);
        }

        rp++;

        while(lp < rp){
            mp = (lp + rp) / 2;
            if(isPossible(mp, lines, n)) lp = mp+1;
            else rp = mp;
        }
        System.out.println(lp - 1);
    }

    private static boolean isPossible(long mp, long[] lines, int N) {
        int count = 0;
        for(long line : lines) count += line / mp;
        return count < N ? false : true;
    }

}
/*
1. 갖고 있는 랜선의 길이를 저장. 최댓값 확인(=rp)
2. 정답의 범위 : lp = 1, rp = 최댓값
3. 분할 정복 : while(lp < rp)
 */