package Level0.공던지기;

public class Solution {
    public int solution(int[] numbers, int k) {
        int ans = (k*2 - 1) % numbers.length;
        if(ans == 0) ans = numbers.length;
        return ans;
    }
}
