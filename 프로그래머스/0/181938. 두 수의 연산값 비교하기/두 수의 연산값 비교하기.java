class Solution {
    public int solution(int a, int b) {
        int p = Integer.parseInt(a + "" + b);
        int m = 2 * a * b;
        return p >= m ? p : m;
    }
}