package Dynamic_programming;

import java.util.Scanner;

public class dy06_최대점수구하기_냅색알고리즘 {
    public static void main(String[] args) {
        dy06_최대점수구하기_냅색알고리즘 T = new dy06_최대점수구하기_냅색알고리즘();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dy=new int[m+1];
        for(int i=0; i<n; i++){
            int ps = sc.nextInt();
            int pt = sc.nextInt();
            for(int j=m; j>=pt; j--){
                dy[j]=Math.max(dy[j], dy[j-pt]+ps);
            }
        }
        System.out.println(dy[m]);
        sc.close();
    }
}
