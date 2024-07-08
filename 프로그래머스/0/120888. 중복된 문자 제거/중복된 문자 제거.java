import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = my_string.toCharArray();
        for(char c : chars) {
            if(set.contains(c)) continue;
            set.add(c);
            sb.append(c);
        }
        return sb.toString();
    }
}