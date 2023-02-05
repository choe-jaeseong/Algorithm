package Level0.양꼬치;

public class Solution {
    public int solution(int n, int k) {
        int price = 12000 * n + 2000 * (k - (n / 10));
        return price;
    }
}
