package 고득점kit.스택_큐.기능개발;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] taken_time = new int[progresses.length];
        for(int i=0; i<taken_time.length; i++){
            taken_time[i] = (100-progresses[i])/speeds[i];
            taken_time[i] += (100-progresses[i])%speeds[i]>0?1:0;
        }
        int day = taken_time[0];
        int cnt = 1;
        for(int i=1; i<taken_time.length; i++){
            if(taken_time[i]>day){
                answer.add(cnt);
                cnt=1;
            }else{
                cnt++;
            }
            day = Math.max(day, taken_time[i]);
        }
        answer.add(cnt);
        int[] ans = answer.stream().mapToInt(i->i).toArray();
        return ans;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr1 = {95, 90, 99, 99, 80, 99};
        int[] arr2 = {1, 1, 1, 1, 1, 1};
        for(int x : T.solution(arr1, arr2))
            System.out.print(x+" ");
    }
}
