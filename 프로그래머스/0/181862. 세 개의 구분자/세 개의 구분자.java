import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] arr = myStr.replaceAll("[abc]", " ").split("[ +]");
        List<String> list = new ArrayList<>();
        for(String s : arr) {
            if(s.equals("")) continue;
            list.add(s);
        }
        
        if(list.size() == 0) 
            return new String[]{"EMPTY"};
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}