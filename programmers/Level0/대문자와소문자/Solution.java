package Level0.대문자와소문자;

import java.util.stream.Collectors;

public class Solution {
    public String solution(String my_string) {
        String ans = "";
        for(char x : my_string.toCharArray()){
            if(x>=97 && x<=122) ans += (char)(x-32);
            else if(x>=65 && x<=90) ans += (char)(x+32);
        }
        return ans;
    }
    //다른 풀이1
    public String solution1(String myString) {
        return myString.chars().mapToObj(operand -> String.valueOf((char) (Character.isLowerCase(operand) ? Character.toUpperCase(operand) : Character.toLowerCase(operand)))).collect(Collectors.joining());
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("abcDEF"));
    }
}
