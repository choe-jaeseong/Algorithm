import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] arr = myString.split("x");
        List<String> list = new ArrayList<>();
        for(String s : arr) {
            if(s.equals("")) continue;
            list.add(s);
        }
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        for(int i=0; i<answer.length; i++) answer[i] = list.get(i);
        return answer;
    }
}