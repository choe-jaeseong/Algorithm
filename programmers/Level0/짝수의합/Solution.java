package Level0.짝수의합;

public class Solution {

    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(i%2==0) answer+=i;
        }
        return answer;
    }

    //다른 사람 풀이
    public int solution2(int n) {
        int answer = 0;
        for(int i=2; i<=n; i+=2){  //조건문 없이 사용 가능
            answer+=i;
        }
        return answer;
    }
}
