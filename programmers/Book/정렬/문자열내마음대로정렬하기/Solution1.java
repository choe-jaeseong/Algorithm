package Book.정렬.문자열내마음대로정렬하기;

/*
* 1. 정렬 Arrays.sort( 람다식 )
*      n번째 글자가 다르면 오름차순
*      같으면 일반 비교함수 compareTo
*/

import java.util.Arrays;

public class Solution1 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b)->{
            if(a.charAt(n) != b.charAt(n)){
                return a.charAt(n) - b.charAt(n);
            }
            return a.compareTo(b);
        });

        return strings;
    }
}
