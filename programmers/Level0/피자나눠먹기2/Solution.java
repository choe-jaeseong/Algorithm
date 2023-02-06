package 피자나눠먹기2;

public class Solution {
    public int GCD(int num1, int num2) {
        if (num1 % num2 == 0)
            return num2;
        return GCD(num2, num1 % num2);
    }

    public int LCM(int num1, int num2) {
        return num1 * num2 / GCD(num1, num2);
    }

    public int solution(int n) {
        return LCM(n, 6) / 6;
    }
}
