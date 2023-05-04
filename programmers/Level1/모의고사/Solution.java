package Level1.모의고사;

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public int[] solution(int[] answers) {
        int[] sp1 = {1,2,3,4,5};
        int[] sp2 = {2,1,2,3,2,4,2,5};
        int[] sp3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        for(int i=0; i<answers.length; i++){
            if(answers[i]==sp1[i%sp1.length]) score[0]++;
            if(answers[i]==sp2[i%sp2.length]) score[1]++;
            if(answers[i]==sp3[i%sp3.length]) score[2]++;
        }
        int max = 0;
        int size = 1;
        for(int j=0; j<3; j++){
            if(max<score[j]) {
                max=score[j];
                size=1;
            } else if(max==score[j]){
                size++;
            }
        }
        int[] answer = new int[size];
        int j=0;
        for(int k=0; k<3; k++){
            if(score[k]==max) answer[j++]=k+1;
        }
        return answer;
    }

    //다른 풀이!!!!!!(코드는 간결하지만 시간이 오래걸림)
    public int[] solution1(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }

    //다른 풀이2
    public static int[] solution2(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];
        for(int i = 0; i < hit.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hit.length; i++)
            if(max == hit[i]) list.add(i + 1);

        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int num : list)
            answer[cnt++] = num;
        return answer;
    }
}
