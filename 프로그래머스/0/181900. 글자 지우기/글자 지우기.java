import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Set<Integer> set = new HashSet<>();
        for(int x : indices) set.add(x);
        
        String result = "";
        for(int i=0; i<my_string.length(); i++) {
            if(set.contains(i)) continue;
            result += my_string.charAt(i);
        }
        return result;
    }
}