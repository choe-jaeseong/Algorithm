package 고득점kit.스택_큐.기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    //다른 풀이1
    public int[] solution1(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
    //다른 풀이2(큐 활용)
    public int[] solution2(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);
            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }
            q.offer(date);
        }
        answerList.add(q.size());
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr1 = {95, 90, 99, 99, 80, 99};
        int[] arr2 = {1, 1, 1, 1, 1, 1};
        for(int x : T.solution(arr1, arr2))
            System.out.print(x+" ");
    }
}
