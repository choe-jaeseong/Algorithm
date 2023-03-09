package Level1.예산;

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0, cost = 0;
        Arrays.sort(d);
        for(int x : d){
            cost += x;
            answer++;
            if(cost > budget) return --answer;
        }
        return answer;
    }
}