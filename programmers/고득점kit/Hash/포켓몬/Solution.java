package 고득점kit.Hash.포켓몬;

import java.util.TreeSet;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        TreeSet<Integer> tset = new TreeSet<>();
        for(int x : nums){
            tset.add(x);
        }
        answer = tset.size()<nums.length/2 ? tset.size(): nums.length/2;
        return answer;
    }
}
