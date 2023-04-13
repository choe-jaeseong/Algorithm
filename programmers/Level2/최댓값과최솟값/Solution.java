package Level2.최댓값과최솟값;

public class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String x : arr){
            int n = Integer.parseInt(x);
            if(min>n) min = n;
            if(max<n) max = n;
        }
        answer+=min+" "+max;
        return answer;
    }
}
