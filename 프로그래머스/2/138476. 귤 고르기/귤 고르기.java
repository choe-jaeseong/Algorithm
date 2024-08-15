import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Integer[] size = new Integer[10_000_001];
        for(int i=0; i<10_000_001; i++) size[i] = 0;
        for(int t : tangerine) size[t]++;
        Arrays.sort(size, Collections.reverseOrder());
        int count = 1;
        for(int s : size) {
            k -= s;
            if(k <= 0) break;
            count++;
        }
        return count;
    }
}