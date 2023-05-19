package 큐.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            q.add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;
        while(!q.isEmpty()){
            int index = q.poll();
            int expiration = (int) Math.ceil((double) (100 - progresses[index]) / speeds[index]);
            if(expiration > days) {
                if (days != 0) {
                    result.add(count);
                    count = 0;
                }
                days = expiration;
            }
            count++;
        }
        result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr1 = {93, 30, 55};
        int[] arr2 = {1, 30, 5};
        for(int x : T.solution(arr1, arr2)) System.out.print(x + " ");
    }
}
