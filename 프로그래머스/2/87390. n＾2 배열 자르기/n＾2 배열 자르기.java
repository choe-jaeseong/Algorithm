import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] arr = new int[(int)(right - left + 1)];
        int startX = (int)(left / n);
        int startY = (int)(left % n);
        int endX = (int)(right / n);
        int endY = (int)(right % n);
        int idx = 0;
        for(int i=startX; i<=endX; i++) {
            for(int j=0; j<n; j++) {
                if(i==startX && j<startY) continue;
                if(i==endX && j>endY) break;
                arr[idx++] = i >= j ? i + 1 : j + 1;
            }
        }
        return arr;
    }
}