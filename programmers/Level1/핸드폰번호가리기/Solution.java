package Level1.핸드폰번호가리기;

public class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int len = phone_number.length();
        for(int i=0; i<len-4; i++){
            answer+="*";
        }
        answer+=phone_number.substring(len-4);
        return answer;
    }

    //다른 풀이1
    public String solution1(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
     }
     //다른 풀이2
     public String solution2(String phone_number) {
        return phone_number.replaceAll(".(?=.{4})", "*");
      }
}
