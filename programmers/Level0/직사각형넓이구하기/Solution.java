package Level0.직사각형넓이구하기;

public class Solution {
    public int solution(int[][] dots) {
        int width = 0, height = 0;
        int[] x = dots[0];
        for(int i=1; i<4; i++){
            if(x[0]==dots[i][0]) height = Math.abs(dots[i][1] - x[1]);
            else if(x[1]==dots[i][1]) width = Math.abs(dots[i][0] - x[0]);
            else continue;
        }
        
        return width * height;
    }
}
