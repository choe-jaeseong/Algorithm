package 고득점kit.Hash.완주하지못한선수;

import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String x : participant) map.put(x, map.getOrDefault(x, 0)+1);
        for(String x : completion) map.put(x, map.get(x)-1);
        for(String x : map.keySet()){
            if(map.get(x)!=0) return x;
        }
        return answer;
    }
}
