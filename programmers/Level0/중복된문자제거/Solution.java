package Level0.중복된문자제거;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String my_string) {
        String answer = "";
        ArrayList<Character> list = new ArrayList<>();
        for(char x : my_string.toCharArray()){
            if(!list.contains(x)) list.add(x);
        }
        for(char x : list) answer += x;
        return answer;
    }

    //다른 풀이1
    public String solution1(String my_string) {
        return my_string.chars()
                .mapToObj(Character::toString)
                .distinct()
                .collect(Collectors.joining());
    }
    //다른 풀이4
    public String solution4(String myString) {
        return Arrays.stream(myString.split("")).distinct().collect(Collectors.joining());
    }
    //다른 풀이2 (중복 없는 set 특성 이용)
    public String solution2(String my_string) {
        String[] answer = my_string.split("");
        Set<String> set = new LinkedHashSet<String>(Arrays.asList(answer));

        return String.join("", set);
    }
    //다른 풀이3 (indexOf 활용)
    public String solution3(String my_string) {
        String answer = "";

        for(int i=0; i<my_string.length(); i++){
            //my_string.indexOf(my_string.charAt(i));
            if(i==my_string.indexOf(my_string.charAt(i)))
                answer+=my_string.charAt(i);
        }

        return answer;
    }
    
    //다른 풀이5 (아스키 활용)
    public String solution5(String my_string) {
        String answer = "";

        boolean[] askii = new boolean[128];

        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if(!askii[c]){
                askii[c] = true;
                answer+=c;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("aabbcc"));
    }
}
