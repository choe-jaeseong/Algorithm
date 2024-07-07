import java.util.*;

class Solution {
    
    private static boolean isValid(long t, int n, int[] times) {
        long c = 0;
        for(int time : times) {
            c += t / time;
        }
        return c >= n;
    }
    public long solution(int n, int[] times) {
        long start = 0;                  //inclusive
        long end = 1000000000000000000L; //inclusive
        
        while(end - start + 1 > 1) {
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