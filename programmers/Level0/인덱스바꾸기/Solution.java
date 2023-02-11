package Level0.인덱스바꾸기;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        char tmp1 = my_string.charAt(num1);
        char tmp2 = my_string.charAt(num2);
        for(int i=0; i<my_string.length(); i++){
            if(i!=num1 && i!=num2) answer += my_string.charAt(i);
            else if (i == num1) answer += tmp2;
            else if (i == num2) answer += tmp1;
        }
        return answer;
    }

    //다른 풀이1
    public String solution1(String myString, int num1, int num2) {
        List<String> list = Arrays.stream(myString.split("")).collect(Collectors.toList());

        Collections.swap(list, num1, num2);
        return String.join("", list);
    }
    //다른 풀이2
    public String solution2(String my_string, int num1, int num2) {
        String answer = "";

        char[] ch = my_string.toCharArray();

        ch[num1] = my_string.charAt(num2);
        ch[num2] = my_string.charAt(num1);

        answer = String.valueOf(ch);
        return answer;
    }



    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("abcde", 1, 3));;
    }
}
