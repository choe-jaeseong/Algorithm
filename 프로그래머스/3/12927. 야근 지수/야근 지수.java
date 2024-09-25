import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int w : works) pq.add(w);
        
        while(n-- > 0 && !pq.isEmpty()) {
            int w = pq.poll() - 1;
            if(w <= 0) continue;
            pq.add(w);
        }
        
        long answer = 0L;
        while(!pq.isEmpty()) answer += Math.pow(pq.poll(), 2);
        return answer;
    }
}