package Level0.삼각형의완성조건2;

public class Solution {
    public int solution(int[] sides) {
        int min = Math.abs(sides[0]-sides[1])+1;
        int max = sides[0]+sides[1] - 1;
        return max - min + 1;
    }
}
