package Level1.이상한문자만들기;

public class Solution {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==' ') {
                answer+=' ';
                cnt=0;
                continue;
            } else {
                if(cnt%2==0) answer += Character.toUpperCase(c);
                else answer += Character.toLowerCase(c);
                cnt++;
            }
        }
        return answer;
    }

    //다른 풀이1
    public String solution1(String s) {

        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase(); 
        }
      return answer;
  }
}
