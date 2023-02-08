package Level0.제곱수판별하기;

public class Solution {
    public int solution(int n) {
        for(int i=1; i*i<=n; i++){
            if(i*i==n) return 1;
        }
        return 2;
    }

    //다른 풀이1
    public int solution1(int n) {
        if (n % Math.sqrt(n) == 0) {
            return 1;
        } else {
            return 2;
        }
    }
    //다른 풀이2
    public int solution2(int n) {
        return Math.sqrt(n) % 1 == 0 ? 1 : 2;
    }
}
