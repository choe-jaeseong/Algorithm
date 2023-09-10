import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        long[][] present = new long[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            present[i][0] = Integer.parseInt(st.nextToken());
            present[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(present, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0], o2[0]);
            }
        });
//        for(long[] x : present) System.out.println(x[0] + " " + x[1]);

        //친구가 1명이면 출력 후 종료
        if(N==1) {
            System.out.println(present[0][1]);
            return;
        }

        //two pointer
        int left=0, right=0;
        long MAX = 0;
        long satisfaction=present[left][1];
        while(right<N){
//            System.out.println(left + " " + right + " " + satisfaction);
            long diff = present[right][0] - present[left][0];
            if(left==right) {
                MAX = Math.max(MAX, satisfaction);
                right++;
                if(right==N) break;
                satisfaction += present[right][1];
            }
            else if(diff >= D) {
                satisfaction -= present[left][1];
                left++;
            }
            else if(diff < D) {
                MAX = Math.max(MAX, satisfaction);
                right++;
                if(right==N) break;
                satisfaction += present[right][1];
            }
        }

        System.out.println(MAX);


    }
}
