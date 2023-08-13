package Level2.요격시스템;

import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int count = 1;
        Arrays.sort(targets, (o1, o2) -> (o1[1] - o2[1]));

        int start = -1;
        int end = targets[0][1];

        for(int i=1; i<targets.length; i++){
            start = targets[i][0];
            if(start < end)
                continue;
            else {
                count++;
                end = targets[i][1];
            }
        }

        return count;
    }
}
