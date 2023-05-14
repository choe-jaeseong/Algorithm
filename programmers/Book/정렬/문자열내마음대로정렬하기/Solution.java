package 정렬.문자열내마음대로정렬하기;

import java.util.Arrays;

public class Solution {
    public String[] solution(String[] strings, int n){
        // Arrays.sort(strings, (s1, s2)->s1.charAt(n) - s2.charAt(n));
        // Arrays.sort(strings, Comparator.comparingInt(s -> s.charAt(n)));
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n) != s2.charAt(n)){
                return s1.charAt(n) - s2.charAt(n);
            }
            return s1.compareTo(s2);  //기본 String 정렬 : compareTo
        });
        
        
        return strings;
    }
}
