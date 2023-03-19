package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class dy05_동전교환_냅색알고리즘 {
    static int n, m;
    static int[] dy;
    public int solution(int[] coinType){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0]=0;
        for(int i=0; i<n; i++){
            for(int j=coinType[i]; j<=m; j++){
                dy[j]=Math.min(dy[j], dy[j-coinType[i]]+1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        dy05_동전교환_냅색알고리즘 T = new dy05_동전교환_냅색알고리즘();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] coinType = new int[n];
        for(int i=0; i<n; i++){
            coinType[i] = sc.nextInt();
        }
        m = sc.nextInt();
        dy=new int[m+1];
        System.out.println(T.solution(coinType));
        sc.close();
    }
}
