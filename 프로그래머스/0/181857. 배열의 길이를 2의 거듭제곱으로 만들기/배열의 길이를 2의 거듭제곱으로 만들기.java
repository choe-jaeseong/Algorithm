import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int size = arr.length;
        int[] answer = null;
        for(int i=1; i<=1024; i*=2) {
            if(size == i) {
                answer = arr;
                break;
            } else if(size < i) {
                answer = Arrays.copyOfRange(arr, 0, i);
                break;
            } 
        } 
        return answer;
    }
}