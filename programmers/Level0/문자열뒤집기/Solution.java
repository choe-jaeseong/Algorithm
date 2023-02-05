package Level0.문자열뒤집기;

public class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        answer = sb.append(my_string).reverse().toString();
        return answer;
    }

    //다른 사람 풀이1
    public String solution2(String myString) {
        return new StringBuilder(myString).reverse().toString();
    }

    //다른 사람 풀이2
    public String solution3(String my_string) {
        String answer = "";

        for(int i=my_string.length()-1; i>=0; i--){
            answer+=my_string.charAt(i);
        }

        return answer;
    }
}
