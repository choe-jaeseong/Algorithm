package 큐.우선순위큐.디스크컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    private static class Job {
        public final int start;
        public final int duration;

        private Job (int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }

    public int solution(int[][] rawjobs) {       
        Job[] jobs = new Job[rawjobs.length];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(rawjobs[i][0], rawjobs[i][1]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.start));
        
        Queue<Job> q = new LinkedList<>(Arrays.asList(jobs));
        PriorityQueue<Job> pq = new PriorityQueue<>(
                Comparator.comparingInt(job -> job.duration));
        
        int exec = 0;   //요청시간 ~ 완료 시간
        int time = 0;   //현재시간
        while(!q.isEmpty() || !pq.isEmpty()){
            while(!q.isEmpty() && q.peek().start <= time) {
                pq.add(q.poll());
            }

            if(pq.isEmpty()) {
                time = q.peek().start;
                continue;
            }

            Job job = pq.poll();
            time += job.duration;
            exec += time - job.start;
        }

        return exec / jobs.length;
    }
}
