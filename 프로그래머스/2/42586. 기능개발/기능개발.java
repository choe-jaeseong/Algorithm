import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] taken = new int[speeds.length];
        for(int i=0; i<taken.length; i++) {
            taken[i] = ((100 - progresses[i]) / speeds[i]) 
                        + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0);
        }
        List<Integer> list = new ArrayList<>();
        int count = 1;
        int now = taken[0];
        for(int i=1; i<taken.length; i++) {
            if(taken[i] > now) {
                list.add(count);
                count = 1;
                now = taken[i];
            } else {
                count++;
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}