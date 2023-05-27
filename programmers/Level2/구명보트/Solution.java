package Level2.구명보트;

import java.util.Arrays;

//투 포인터
class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        
        int lp = 0, rp = people.length - 1;
        boolean[] getout = new boolean[people.length];
        while(lp < rp) {
            if(people[lp] + people[rp] <= limit) {
                count++;
                getout[lp++] = true;
                getout[rp--] = true;
            } else {
                count++;
                getout[rp--] = true;
            }
        }
        if(!getout[lp]) count++;
        
        return count;
    }
}
