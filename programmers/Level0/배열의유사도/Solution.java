package Level0.배열의유사도;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String x : s1){
            for(String y : s2){
                if(x.compareTo(y)==0) answer++;
            }
        }
        return answer;
    }

    //다른 풀이1
    public int solution1(String[] s1, String[] s2) {
        int answer = 0;
        HashSet<String> set = new HashSet<>(List.of(s1));
        for (String s : s2) {
            if(set.contains(s)){
                answer++;
            }
        }
        return answer;
    }
    //다른 풀이2
    public int solution2(String[] s1, String[] s2) {
        Set<String> set = new HashSet<>(Arrays.asList(s1));
        return (int)Arrays.stream(s2).filter(set::contains).count();
    }
}
