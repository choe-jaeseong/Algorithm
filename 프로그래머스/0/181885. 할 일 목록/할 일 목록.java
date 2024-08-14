import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> arr = new ArrayList<>();
        for(int i=0; i<finished.length; i++) {
            if(finished[i] == false) {
                arr.add(todo_list[i]);
            }
        }
        
        String[] answer = new String[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}