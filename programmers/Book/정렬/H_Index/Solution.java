package Book.정렬.H_Index;

import java.util.Arrays;

public class Solution {
    
    //책 풀이
    private boolean isValid(int[] citations, int h){
        int index = citations.length - h;
        return citations[index] >= h;
    }
    public int solution(int[] citations){
        Arrays.sort(citations); //시간복잡도 : nlog(n)
        for(int h = citations.length; h >= 1; h--){
            if(isValid(citations, h)) return h;
        }
        return 0;
    }

    //나의 풀이
    // public int solution(int[] citations){
    //     Arrays.sort(citations);

    //     for(int h = citations[citations.length-1]; h > 0; h--){
    //         int used = 0;
    //         for(int i = citations.length - 1; i >= 0; i--){
    //             if(citations[i]>=h) used++;
    //             else break;
    //         }
    //         if(used >= h) return h;
    //     }
    //     return 0;
    // }
}
