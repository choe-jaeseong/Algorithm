import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        for(String str : intStrs) {
            int sub = Integer.parseInt(str.substring(s, s + l));
            if(sub > k) list.add(sub);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) answer[i] = list.get(i);
        return answer;
    }
}