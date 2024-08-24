import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
            return (a1[1]-a1[0]) - (a2[1]-a2[0]);
        });
        
        int lp = 0;
        int rp = 0;
        int sum = sequence[0];
        while(lp<=rp && rp<sequence.length) {
            if(sum == k) {
                pq.add(new int[]{lp, rp});
                if(rp == sequence.length - 1) {
                    break;
                } else {
                    sum += sequence[++rp];
                }
            } else if(sum > k) {
                sum -= sequence[lp++];
            } else {
                if(rp == sequence.length - 1) {
                    break;
                } else {
                    sum += sequence[++rp];
                }
            }
        }
        
        return pq.poll();
    }
}