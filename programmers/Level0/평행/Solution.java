package Level0.평행;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots, (o1, o2) -> {return o1[0]-o2[0];});
        double v1 = dots[0][0]-dots[1][0];
        double v2 = dots[0][1]-dots[1][1];
        double p1 = dots[2][0]-dots[3][0];
        double p2 = dots[2][1]-dots[3][1];
        if(v1/p1 == v2/p2) return 1;
        v1 = dots[0][0]-dots[2][0];
        v2 = dots[0][1]-dots[2][1];
        p1 = dots[1][0]-dots[3][0];
        p2 = dots[1][1]-dots[3][1];
        if(v1/p1 == v2/p2) return 1;
        return 0;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] dots = {{1,4}, {9, 2}, {3, 8}, {11, 6}};
        System.out.println(T.solution(dots));
    }
}
