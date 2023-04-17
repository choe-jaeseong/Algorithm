package 고득점kit.Heap.더맵게;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : scoville) pq.offer(x);
        while(pq.peek()<K){
            int t1 = pq.poll();
            int t2 = pq.poll();
            pq.offer(t1+t2*2);
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1, 2, 3, 9, 10, 12}; 
        System.out.println(T.solution(arr, 7));
    }
}
