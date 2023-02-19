package Level0.등수매기기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[] solution(int[][] score) {
        int[] ans = new int[score.length];
        Double[] avg = new Double[score.length];
        for(int i=0; i<score.length; i++){
            avg[i] = (double)(score[i][0] + score[i][1])/2;
        }
        Arrays.sort(avg,Collections.reverseOrder());
        for(int i=0; i<score.length; i++){
            double a = (double)(score[i][0] + score[i][1])/2;
            for(int j=0; j<score.length; j++){
                if(a==avg[j]) {
                    ans[i] = j+1;
                    break;
                }
            }
        }
        return ans;
    }

    //다른 풀이1
    public int[] solution1(int[][] score) {
        List<Integer> scoreList = new ArrayList<>();
        for(int[] t : score){
            scoreList.add(t[0] + t[1]);
        }
        scoreList.sort(Comparator.reverseOrder());

        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            answer[i] = scoreList.indexOf(score[i][0] + score[i][1])+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] score = {{80,70},{90, 50},{40, 70},{50, 80},{75,75}};
        for(int x : T.solution(score)) System.out.println(x);
    }
}
