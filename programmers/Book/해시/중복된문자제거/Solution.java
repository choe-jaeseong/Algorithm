package 해시.중복된문자제거;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    public String solution2(String myString) {
        Set<Character> used = new HashSet<>();

        StringBuilder builder = new StringBuilder();
        for (char c : myString.toCharArray()) {
            if (used.contains(c)) continue;
            used.add(c);
            builder.append(c);
        }

        return builder.toString();
    }

    //나의 답
    public String solution(String my_string){
        String answer = "";
        Set<Character> set = new HashSet<>();

        for(char x : my_string.toCharArray()){
            if(!set.contains(x)) {
                answer += x;
                set.add(x);
            } else {
                continue;
            }
        }

        return answer;
    }
}
