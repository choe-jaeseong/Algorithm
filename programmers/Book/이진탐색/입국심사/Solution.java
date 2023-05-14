package 이진탐색.입국심사;

public class Solution {
    
    private boolean isValid(long t, int n, int[] times){
        long c = 0;
        for(int time : times){
            c += t / time;
        }
        return c >= n;
    }
    public long solution(int n, int[] times) {
        long start = 1;
        long end = 1000000000000000000L;
        
        while(end - start > 0){
            long t = (start + end) / 2;

            if(isValid(t, n, times)) {
                end = t;
            } else {
                start = t + 1;
            }
        }

        return start;
    }
    
}
