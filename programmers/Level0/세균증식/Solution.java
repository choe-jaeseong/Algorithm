package Level0.세균증식;

public class Solution {
    public int solution(int n, int t) {
        return n * (int)Math.pow(2, t);
    }

    //다른 풀이
    public int solution1(int n, int t) {
        int answer = 0;
        answer = n << t;
        return answer;
    }
}
