import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> delete_set = new HashSet<>();
        for(int x : delete_list) delete_set.add(x);
        for(int x : arr) {
            if(delete_set.contains(x)) continue;
            list.add(x);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}