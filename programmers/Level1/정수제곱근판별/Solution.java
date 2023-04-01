package Level1.정수제곱근판별;

public class Solution {
    public long solution(long n) {
        Double a = Math.sqrt(n);    //Double wrapper class 를 int로 변환 (intValue)
        if(a==a.intValue()) return (long)Math.pow(a+1, 2);
        else return -1;
    }

    //다른 풀이1
    public long solution1(long n) {
        if(Math.pow((int)Math.sqrt(n), 2) == n) {
              return (long)Math.pow(Math.sqrt(n) + 1, 2);
        }
        return -1;
    }
}
