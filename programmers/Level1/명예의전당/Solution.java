package Level1.명예의전당;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<score.length; i++){
            arr.add(score[i]);
            arr.sort((num1,num2)->num2-num1);
            if(i<k-1) answer[i]=arr.get(i);
            else answer[i]=arr.get(k-1);
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {10, 100, 20, 150, 1, 100, 200};
        for(int x : T.solution(3, arr)) System.out.print(x + " ");
    }
}
