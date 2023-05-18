package 큐.기능개발;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    
    public int[] solution(int[] progress, int[] speeds){
        int[] taken_time = new int[progress.length];
        for(int i = 0; i < progress.length; i++){
            taken_time[i] = (100 - progress[i]) / speeds[i];
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progress.length; i++){
            int count = 1;
            int tmp = taken_time[i];
            if(i == progress.length - 1){
                q.add(1);
                break;
            }
            while (++i < progress.length && taken_time[i] <= tmp) count++;
            i--;
            q.add(count);          
        }

        int[] answer = new int[q.size()];
        for(int i = 0; i < q.size(); i++){
            answer[i] = q.poll();
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr1 = {93, 30, 55};
        int[] arr2 = {1, 30, 5};
        for(int x : T.solution(arr1, arr2)) System.out.print(x + " ");
    }
}
