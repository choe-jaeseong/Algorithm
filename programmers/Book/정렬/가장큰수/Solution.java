package 정렬.가장큰수;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String solution(int[] numbers){
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf) //모두 문자열로 변환
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    return reversed - original;
                })
                .collect(Collectors.joining("")) //stream을 하나의 문자열로 구성할 때, Collectors.joining("")
                .replaceAll("^0+", "0"); //^: 문자열의 시작, +: 1개 이상 나올 때
    }
}
