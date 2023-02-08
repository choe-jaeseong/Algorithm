package Level0.암호해독;

public class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        for(int i=code-1; i<cipher.length(); i+=code){
            answer += cipher.charAt(i);
        }
        return answer;
    }

    //다른 풀이1
    public String solution1(String cipher, int code) {
        String answer = "";
        for(int i=code-1; i<cipher.length(); i+=code){
            answer += cipher.substring(i, i+1);
        }
        return answer;
    }
    //다른 풀이2
    public String solution2(String cipher, int code) {
        String[] arr = cipher.split("");
        StringBuilder sb = new StringBuilder();
        int x = code-1;
        while(x < arr.length) {
            sb.append(arr[x]);
            x += code;
        }

        return sb.toString();
    }
}
