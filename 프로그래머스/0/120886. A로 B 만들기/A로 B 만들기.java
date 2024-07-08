import java.util.*;

class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charsB = before.toCharArray();
        char[] charsA = after.toCharArray();
        for(int i=0; i<before.length(); i++) {
            map.put(charsB[i], map.getOrDefault(charsB[i], 0) + 1);
        }
        for(int i=0; i<after.length(); i++) {
            char c = charsA[i];
            if(map.getOrDefault(c, 0) == 0) return 0;
            map.put(c, map.get(c) - 1);
        }
        return 1;
    }
}