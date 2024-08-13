class Solution {
    public int solution(int[] num_list) {
        int odd = 0;
        int even = 0;
        for(int x : num_list) {
            if(x % 2 == 1) {
                odd *= 10;
                odd += x;
            } else {
                even *= 10;
                even += x;
            }
        }
        return odd + even;
    }
}