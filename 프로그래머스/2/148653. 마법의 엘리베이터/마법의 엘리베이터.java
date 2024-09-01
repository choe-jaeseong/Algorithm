//10:34

import java.util.*;

class Solution {
    
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0) {
            int one = storey % 10;
            storey /= 10;
            if(one > 5) {
                answer += (10 - one);
                storey++;
            } else if(one == 5) {
                if(storey % 10 >= 5) {
                    answer += (10 - one);
                    storey++;
                } else {
                    answer += 5;
                }
            } else {
                answer += one;
            }
        }
        return answer;
    }
}