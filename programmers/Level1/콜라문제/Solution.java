package Level1.콜라문제;

public class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int tmp = n;
        while(tmp>=a){
            answer += tmp/a*b;
            tmp = tmp/a*b + tmp%a;
        }
        return answer;
        
    }

}
