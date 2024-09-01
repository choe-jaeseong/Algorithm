class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        double standard = Math.pow(d, 2);
        for(int i=0; i<=d; i+=k) {
            long diff = (long) Math.sqrt(standard - Math.pow(i, 2));
            answer += diff / k + 1;
        }
        return answer;
    }
}