import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for(int h=citations.length; h>=1; h--) {
            if(isValid(h, citations)) return h;
        }
        return 0;
    }
    
    private static boolean isValid(int h, int[] citations) {
        int index = citations.length - h;
        return citations[index] >= h;
    }
}
