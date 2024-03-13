import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] routers = new int[N];
        for(int i=0; i<N; i++) routers[i] = Integer.parseInt(br.readLine());

        Arrays.sort(routers);

        int lo = 1;
        int hi = routers[N-1] - routers[0] + 1;
        int mid = 0;
        while(lo < hi) {
            mid = (lo + hi) / 2;
            if(canInstall(mid, routers) < C) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo - 1);
    }

    private static int canInstall(int interval, int[] routers) {
        int count = 1;
        int lastIdx = 0;
        for(int i=1; i<routers.length; i++) {
            if(routers[i] - routers[lastIdx] >= interval) {
                lastIdx = i;
                count++;
            }
        }

        return count;
    }
}


/*
목표 : 만족하는 사이 거리 중 최대 거리

mid = 가장 인접한 거리 중 최대 값.
 */