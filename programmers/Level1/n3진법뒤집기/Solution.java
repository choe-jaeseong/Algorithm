package Level1.n3진법뒤집기;

public class Solution {
    public int solution(int n) {
        String arith3_reverse = "";
        long answer = 0;
        while(n>0){
            arith3_reverse+=n%3;
            n/=3;
        }
        n = Integer.parseInt(arith3_reverse, 3);
        System.out.println(n);
        int i=0;
        while(n>0){
            answer += ((long)n%10) * Math.pow(3, i++);
            n /= 10;
        }
        return (int)answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(45));
    }
}
