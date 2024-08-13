class Solution {
    public int solution(int[] num_list) {
        int m = 1;
        int s = 0;
        for(int n : num_list) {
            m *= n;
            s += n;
        }
        return m < Math.pow(s, 2) ? 1 : 0;
    }
}