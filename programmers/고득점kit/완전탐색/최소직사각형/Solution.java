package 고득점kit.완전탐색.최소직사각형;

public class Solution {
    public int solution(int[][] sizes) {
        int w=0, h=0;
        for(int[] x : sizes){
            if(x[0]<x[1]){
                w = Math.max(w, x[0]);
                h = Math.max(h, x[1]);
            } else {
                w = Math.max(w, x[1]);
                h = Math.max(h, x[0]);
            }
        }
        return w * h;
    }
    
    //다른 풀이1
    public int solution1(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }
}
