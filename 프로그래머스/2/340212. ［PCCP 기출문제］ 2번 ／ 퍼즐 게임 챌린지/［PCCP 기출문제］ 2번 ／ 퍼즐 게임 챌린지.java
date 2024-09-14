class Solution {
    
    private static int[] diffs;
    private static int[] times;
    private static long limit;
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        int lp = 1, rp = 100000;
        while(rp - lp > 0) {
            int mid = (lp + rp) / 2;
            if(isPossible(mid)) {
                rp = mid;
            } else {
                lp = mid + 1;
            }
        }
        return lp;
    }
    private static boolean isPossible(int level) {
        long taken = 0;
        
        for(int i=0; i<diffs.length; i++) {
            if(diffs[i] <= level) {
                taken += times[i];
            } else {
                int wrong = diffs[i] - level;
                int time_prev = i == 0 ? 0 : times[i - 1];
                taken += (long)(times[i] + time_prev) * wrong + times[i];
            }
            if(taken > limit) return false;
        }
        return true;
    }
}

/*
이진탐색
target = 숙련도의 최솟값 [lp, rp]
*/