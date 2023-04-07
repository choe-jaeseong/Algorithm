package Level1.문자열나누기;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            char x = s.charAt(i++);
            int cnt_x = 1, cnt_y = 0;
            while(i<s.length() && cnt_x!=cnt_y){
                if(s.charAt(i++)==x) cnt_x++;
                else cnt_y++;
            }
            i--;
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("aaabbaccccabba"));
    }
}
