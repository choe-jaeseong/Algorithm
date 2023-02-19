package Level0.저주의숫자3;

public class Solution {
    public int solution(int n) {
        int cnt = 0;
        for(int i=1; i<200; i++){
            int tmp = i;
            if(tmp%3==0) continue;
            if(tmp%10==3) continue;
            tmp/=10;
            if(tmp>0 && tmp%10==3) continue;
            cnt++;
            if(cnt==n) return i;
        }
        return -1;
    }

    //다른 풀이1
    public int solution1(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer++;
            if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                i--;
            }
        }
        return answer;
    }
    
    //다른 풀이2
    public int solution2(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer = get3xNationNumber(answer + 1);
        }
        return answer;
    }
    private int get3xNationNumber(int n) {
        if (n % 3 == 0) {
            return get3xNationNumber(n + 1);
        }
        if (String.valueOf(n).contains("3")) {
            return get3xNationNumber(n + 1);
        }
        return n;
    }
}
