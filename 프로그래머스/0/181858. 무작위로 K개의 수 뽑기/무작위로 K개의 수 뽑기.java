import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int x : arr) {
            if(!set.contains(x)) {
                set.add(x);
                list.add(x);
            }
        }
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        for(int i=0; i<list.size() && i < k; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}