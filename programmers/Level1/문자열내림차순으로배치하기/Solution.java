package Level1.문자열내림차순으로배치하기;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder answer = new StringBuilder(new String(arr));
        return answer.reverse().toString();
    }

    //다른 풀이1
    public String reverseStr1(String str){
        char[] sol = str.toCharArray();
    Arrays.sort(sol);
    return new StringBuilder(new String(sol)).reverse().toString();
    }
    //다른 풀이2
    public String reverseStr2(String str){
        String[] arry = str.split("");
        Arrays.sort(arry,  Collections.reverseOrder());
        StringBuffer sb = new StringBuffer();
        for( String s : arry )
        {
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("cba"));
    }
}
