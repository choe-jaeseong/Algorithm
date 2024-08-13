class Solution {
    public int solution(int a, int b) {
        int s1 = Integer.parseInt(a + "" + b);
        int s2 = Integer.parseInt(b + "" + a);
        return s1 >= s2 ? s1 : s2;
    }
}