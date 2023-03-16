package Level1.년2016년;

public class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] Month_days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] Day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int sum = 0;
        for(int i=0; i<a-1; i++) sum += Month_days[i];
        sum += b;
        answer += Day[sum%7];
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(5, 24));
    }
}
