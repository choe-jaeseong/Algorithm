package 배열원소의길이;

import java.util.Arrays;

public class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        for(int i=0; i<strlist.length; i++){
            answer[i] = strlist[i].length();
        }
        
        return answer;
    }

    //다른 사람 풀이1
    public int[] solution1(String[] strList) {
        return Arrays.stream(strList).mapToInt(String::length).toArray();
    }
    //다른 사람 풀이2
    public int[] solution2(String[] strlist) {
        return Arrays.stream(strlist)
            .map(element -> element.length())
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}
