package 고득점kit.Heap.더맵게;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : scoville) pq.offer(x);
        while(!pq.isEmpty() && pq.peek()<K){
            int t1 = pq.poll();
            if(pq.isEmpty()) return -1;
            int t2 = pq.poll();
            pq.offer(t1+t2*2);
            answer++;
        }
        return answer;
    }

    //다른 풀이1
    public int solution1(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++)
            q.add(scoville[i]);
        int count = 0;
        while(q.size() > 1 && q.peek() < K){
            int weakHot = q.poll();
            int secondWeakHot = q.poll();
            int mixHot = weakHot + (secondWeakHot * 2);
            q.add(mixHot);
            count++;
        }
        if(q.size() <= 1 && q.peek() < K)
            count = -1;
        return count;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1, 2, 3, 9, 10, 12}; 
        System.out.println(T.solution(arr, 7));
    }
}
