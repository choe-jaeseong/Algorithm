class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int num : num_list) {
            answer += count(num);
        }
        return answer;
    }
    
    private static int count(int num) {
        int c = 0;
        int tmp = num;
        while(tmp != 1) {
            if(tmp % 2 == 0) {
                tmp /= 2;
            } else {
                tmp = (tmp - 1) / 2;
            }
            c++;
        }
        return c;
    }
}