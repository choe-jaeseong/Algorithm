import java.util.*;

class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<my_strings.length; i++) {
            String s = my_strings[i];
            int start = parts[i][0];
            int end = parts[i][1];
            String sub = s.substring(start, end + 1);
            sb.append(sub);
        }
        return sb.toString();
    }
}