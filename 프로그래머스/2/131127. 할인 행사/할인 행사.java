import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<10; i++) 
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        if(check(map, want, number)) answer++;
        
        for(int i=10; i<discount.length; i++) {
            map.put(discount[i-10], map.get(discount[i-10]) - 1);
            if(map.get(discount[i-10])==0) map.remove(discount[i-10]);
            
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            
            if(check(map, want, number)) answer++;
        }
        
        return answer;
    }
    
    private static boolean check(Map<String, Integer> map, String[] want, int[] number) {
        for(int i=0; i<want.length; i++) {
            String w = want[i];
            int n = number[i];
            int count = map.getOrDefault(w, 0);
            if(count < n) return false;
        }
        return true;
    }
}