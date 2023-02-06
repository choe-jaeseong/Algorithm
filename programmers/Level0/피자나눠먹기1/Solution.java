package 피자나눠먹기1;

public class Solution {
    public int solution(int n) {
        return n % 7 == 0 ? n / 7 : n / 7 + 1;
    }
}
