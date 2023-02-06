package 피자나눠먹기3;

public class Solution {
    public int solution(int slice, int n) {
        return n % slice > 0 ? n/slice+1 : n/slice;
    }
}
