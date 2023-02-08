package Level0.숨어있는숫자의덧셈1;

import java.util.regex.Pattern;

public class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(char x : my_string.toCharArray()){
            if(x>=48 && x<=57) answer += x - 48;
        }
        return answer;
    }

    //다른 풀이1
    public int solution1(String myString) {
        return myString.chars().mapToObj(i -> (char) i).filter(Character::isDigit).map(String::valueOf).mapToInt(Integer::valueOf).sum();
    }
    //다른 풀이2
    public int solution2(String my_string) {
        int answer = 0;
        String str = my_string.replaceAll("[^0-9]","");

        for(char ch : str.toCharArray()) {
            answer += Character.getNumericValue(ch);
        }

        return answer;
    }
    //다른 풀이3
    public int solution3(String my_string) {
        int answer = 0;
        String pattern = "^[0-9]*$";
        String[] list = my_string.split("");

        for(int i = 0; i < list.length; i ++) {
            if(Pattern.matches(pattern,list[i])) {
                answer += Integer.parseInt(list[i]);
            }
        }
        return answer;
    }
    //다른 풀이4
    public int solution4(String my_string) {
        int answer = 0;
        for(int i=0; i<my_string.length(); i++){
            if(Character.digit(my_string.charAt(i), 10) > 0){
                answer += Integer.parseInt(String.valueOf(my_string.charAt(i)));
            }
        }
        return answer;
    }
    //다른 풀이5
    public int solution5(String s) {
        int answer = 0;

        for(int i=0; i<s.length();i++){
            if(s.charAt(i)>48 && s.charAt(i)<58){
                answer += Integer.parseInt("" + s.charAt(i)) ;
            }
        }

        return answer;
    }
}
