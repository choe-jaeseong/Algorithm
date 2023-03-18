package Dynamic_programming;

import java.util.Scanner;

class dy01_계단오르기 {
    static int[] dy;
    public int solution(int n){
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n; i++){
            dy[i]=dy[i-2]+dy[i-1];
        }
        return dy[n];
    }
    public static void main(String[] args) {
        dy01_계단오르기 T = new dy01_계단오르기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+1];
        System.out.println(T.solution(n));
    }
}