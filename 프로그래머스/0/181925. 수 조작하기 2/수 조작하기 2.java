import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        
        int prev = numLog[0];
        for(int i=1; i<numLog.length; i++) {
            int now = numLog[i];
            switch(now - prev) {
                    case 1 -> sb.append('w');
                    case -1 -> sb.append('s');
                    case 10 -> sb.append('d');
                    case -10 -> sb.append('a');
            }
            prev = now;
        }
        
        return sb.toString();
    }
}