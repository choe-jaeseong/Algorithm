package 고득점kit.Heap.디스크컨트롤러;

/*
 * 풀이 다시 보기.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, current_time=0;
        Arrays.sort(jobs, (o1,o2)->o1[0]-o2[0]); //시작시간 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]); //처리시간 오름차순
        int i = 0;
        while(i<jobs.length || !pq.isEmpty()){
            while(i<jobs.length && jobs[i][0]<=current_time){
                pq.offer(new int[] {jobs[i][0], jobs[i][1]});
                i++;
            }
            if(pq.isEmpty()){   //현재 실행할 수 있는 작업이 비어있다.
                current_time = jobs[i][0];
            } else {            //현재 실행중인 작업이 있다.
                int[] tmp = pq.poll();
                answer += current_time+tmp[1]-tmp[0]; //요청~종료시간
                current_time+=tmp[1];
            }
        }
        return answer/jobs.length;
    }
}
