import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        while(true) {
            int[] tmp = arr.clone();
            for(int i=0; i<tmp.length; i++) {
                if(tmp[i]>=50 && tmp[i] % 2 == 0) {
                    tmp[i] /= 2;
                } else if(tmp[i] < 50 && tmp[i] % 2 == 1){
                    tmp[i] = tmp[i] * 2 + 1;
                }
            }
            
            if(isSame(arr, tmp)) return answer;
            arr = tmp;
            answer++;
        }
    }
    private static boolean isSame(int[] arr, int[] tmp) {
        for(int i=0; i<arr.length; i++) 
            if(arr[i] != tmp[i])
                return false;
        return true;
    }
}