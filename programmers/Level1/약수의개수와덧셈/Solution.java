package Level1.약수의개수와덧셈;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int cnt_divisor(int n){
        int cnt = 0;
        for(int i=1; i*i<=n; i++){
            if(i*i==n) cnt++;
            else if(n % i == 0) cnt+=2;
        }
        return cnt;
    }
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            if(cnt_divisor(i)%2==0) answer+=i;
            else answer-=i;
        }
        return answer;
    }
    //다른 풀이1
    public int solution1(int left, int right) {
        int answer = 0;

        for (int i=left;i<=right;i++) {
            //제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            //제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }

        return answer;
    }
    //다른 풀이2
    public int solution2(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += i * ((countDenominators(i) % 2 == 0) ? 1 : -1);
        }
        return sum;
    }
    private int countDenominators(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) if (num % i == 0) count++;
        return count;
    }
    //다른 풀이3
    int yaksu(int x) {
        if(x == 1) return 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= x / 2; i++) {
            if(x % i == 0) {
                set.add(i);
                set.add(x / i);
            }
        }
        return set.size();
    }
    public int solution3(int left, int right) {
        int answer = 0;
        for(; left <= right; left++) answer += left * (yaksu(left) % 2 == 0 ? 1 : -1);
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(13, 17));
    }
}
