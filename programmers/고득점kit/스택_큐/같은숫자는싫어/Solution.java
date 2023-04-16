package 고득점kit.스택_큐.같은숫자는싫어;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i]==arr[i-1]) continue;
            else list.add(arr[i]);
        }
        int[] answer = list.stream()
                        .mapToInt(i->i)
                        .toArray();
        return answer;
    }
}
