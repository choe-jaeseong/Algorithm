package Level0.한번만등장한문자;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String s) {
        String answer = "";
        int[] alphabet = new int[128];
        for(char x : s.toCharArray()) alphabet[x]++;
        for(int i=97; i<=122; i++){
            if(alphabet[i]==1) answer += (char)i;
        }
        return answer;
    }

    //다른 풀이1
    public String solution1(String s) {
        return Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(s1 -> s1))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() <= 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.joining());
    }
    //다른 풀이2
    public String solution2(String s) {
        int[] alpha = new int[26];
        for(char c : s.toCharArray()){
            alpha[c - 'a']++;
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(alpha[i] == 1){
                answer.append((char)(i + 'a'));
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("aabbccdef"));
    }
}
