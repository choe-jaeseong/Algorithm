package Level0.중복된문자제거;

import java.util.ArrayList;

public class Solution {
    public String solution(String my_string) {
        String answer = "";
        ArrayList<Character> list = new ArrayList<>();
        for(char x : my_string.toCharArray()){
            if(!list.contains(x)) list.add(x);
        }
        for(char x : list) answer += x;
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("aabbcc"));
    }
}
