package Level1.문자열내마음대로정렬하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<String> list = new ArrayList<>();
        
        for(String x : strings){
            list.add(x.charAt(n)+x);  //key point
        }
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).substring(1);
        }

        return answer;
    }

    //다른 풀이1
    public String[] solution1(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.charAt(n) > s2.charAt(n)) return 1;
                else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                else if(s1.charAt(n) < s2.charAt(n)) return -1;
                else return 0;
            }
        });
        return strings;
    }
}
