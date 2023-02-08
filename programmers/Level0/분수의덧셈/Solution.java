package Level0.분수의덧셈;

public class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int x = numer1 * denom2 + numer2 * denom1;
        int y = denom1 * denom2;
        
        int max = 1;
        for(int i=2; i<=x && i<=y; i++){
            if(x%i==0 && y%i==0) max = i;
        }
        answer[0] = x / max;
        answer[1] = y / max;
        return answer;
    }
}
