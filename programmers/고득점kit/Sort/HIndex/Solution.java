package 고득점kit.Sort.HIndex;

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int h=citations.length-i;
            if(citations[i]>=h){
                answer=h;
                break;
            }
        }
        return answer;
    }

    //다른 풀이1
    public int solution1(int[] citations){
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            if(smaller>=answer)
                answer = Math.max(answer, smaller);
            else
                break;
        }
        return answer;
    }
}
