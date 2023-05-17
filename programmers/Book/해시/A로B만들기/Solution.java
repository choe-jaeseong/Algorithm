package 해시.A로B만들기;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    //강의 답
    private static Map<Character, Integer> toMap(String word){
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()){
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    public int solution1(String before, String after){
        return toMap(before).equals(toMap(after)) ? 1 : 0;
    }

    //나의 답 - 오답 (after의 값이 before keySet에 없는 경우도 고려하기)
    // public int solution(String before, String after){
    //     Map<Character, Integer> used = new HashMap<>();
    //     for(char c : before.toCharArray()){
    //         used.put(c, used.getOrDefault(c, 0) + 1);
    //     }

    //     for(char c : after.toCharArray()){
    //         used.put(c, used.get(c) - 1);
    //         if(used.get(c) < 0) return 0;
    //     }

    //     return 1;
    // }
}
