package 고득점kit.Hash.위장;

import java.util.HashMap;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        for(int cnt : map.values()){
            answer*=(cnt+1);
        }
        return answer-1;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String[][] arr = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.println(T.solution(arr));
    }
}
