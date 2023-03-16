package Level1.가운데글자가져오기;

public class Solution {
    public String solution(String s) {
        String answer = "";
        int size = s.length();
        if(size%2==0){
            answer += s.charAt(size/2-1);
            answer += s.charAt(size/2);
        } else {
            answer += s.charAt(size/2);
        }
        return answer;
    }

    //다른 풀이1
    String getMiddle(String word){
        return word.substring((word.length()-1)/2, word.length()/2 + 1);
    }

    //다른 풀이2
    String getMiddle2(String word){
        int a = word.length();
        String word1;
        if ( a % 2 == 0 )
                word1 = word.substring(a/2 - 1, (a/2) + 1);
        else
                word1 = word.substring((a/2), (a/2) + 1);
        return word1;
    }
}
