import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(String s : strArr) {
            int n = s.length();
            map.put(n, map.getOrDefault(n, 0) + 1);
            max = Math.max(max, map.get(n));
        }
        return max;
    }
}