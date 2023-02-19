package Level0.치킨쿠폰;

public class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while(chicken<10){
            answer += chicken/10;
            chicken = chicken/10 + chicken%10;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(1999));
    }
}
