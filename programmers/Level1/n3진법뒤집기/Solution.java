package Level1.n3진법뒤집기;

public class Solution {
    public int solution(int n) {
        String arith3_reverse = "";
        while(n>0){
            arith3_reverse+=n%3;
            n/=3;
        }
        return Integer.parseInt(arith3_reverse, 3);
    }
    //다른 풀이1
    public int solution1(int n) {
        String a = "";

        while(n > 0){
            a = (n % 3) + a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();


        return Integer.parseInt(a,3);
    }
    //다른 풀이2
    public int solution2(int n) {
        int answer = 0;
        String third = Integer.toString(n, 3);
        StringBuffer sb = new StringBuffer(third);
        String reversed = sb.reverse().toString();

        int exp = 0;
        for (int i = reversed.length() - 1; i >= 0; i--) {
            answer += Integer.parseInt(String.valueOf(reversed.charAt(i))) * Math.pow(3, exp);
            exp++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(45));
    }
}
