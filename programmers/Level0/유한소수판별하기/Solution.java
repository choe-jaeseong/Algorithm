package Level0.유한소수판별하기;

public class Solution {
    public int gcd(int a,int b){
        int r = 0;
        while(b != 0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public int solution(int a, int b) {
        int gcd = gcd(a, b);
        b = b / gcd;
        while(b%2==0) b/=2;
        while(b%5==0) b/=5;
        if(b==1) return 1;
        else return 2;
    }

    //다른 풀이1
    public int solution1(int a, int b) {
        int answer = ((a*1000)%b == 0) ? 1 : 2;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(7, 20));
    }
}
