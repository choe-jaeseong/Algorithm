package Level1.시저암호;

public class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(char x : s.toCharArray()){
            if(x==' ') answer += x;
            else if(x >= 97){
                answer += (char)((x - 97 + n) % 26 + 97);
            } else {
                answer += (char)((x - 65 + n) % 26 + 65);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("a B c", 1));
    }
}
