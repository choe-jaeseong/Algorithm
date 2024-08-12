import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        int soldier = n;
        int skill = k;
        
        for(int i=0; i<enemy.length; i++) {
            soldier -= enemy[i];
            q.add(enemy[i]);
            
            if(soldier < 0) {
                if(skill > 0) {
                    skill--;
                    soldier += q.poll();
                } else {
                    return i;
                }
            }
            answer = i + 1;
        }
        
        return answer;
    }
}