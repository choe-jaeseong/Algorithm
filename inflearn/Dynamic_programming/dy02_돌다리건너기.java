package Dynamic_programming;

import java.util.Scanner;

public class dy02_돌다리건너기 {
    static int[] dy;
    public int solution(int n){
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n+1; i++){
            dy[i] = dy[i-1] + dy[i-2];
        }
        return dy[n+1];
    }
    public static void main(String[] args) {
        dy02_돌다리건너기 T = new dy02_돌다리건너기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+2];
        System.out.println(T.solution(n));
        sc.close();
    }
}
