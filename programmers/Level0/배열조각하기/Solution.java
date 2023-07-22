package Level0.배열조각하기;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        for(int i = 0; i < query.length; i++){
            int[] tmp;
            if(i % 2 == 0){
                tmp = new int[query[i]+1];
                tmp = Arrays.copyOf(arr, tmp.length);    
            } else {
                tmp = new int[arr.length - query[i]];
                System.arraycopy(arr, query[i], tmp, 0, tmp.length);
            }
            arr = tmp;
        }
        return arr;
    }
}
