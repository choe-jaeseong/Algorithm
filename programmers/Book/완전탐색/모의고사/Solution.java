package 완전탐색.모의고사;

import java.util.stream.IntStream;

public class Solution {
    //책 풀이
    private static final int[][] RULES = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
    };

    private int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int index = problem % rule.length;
        return rule[index];
    }

    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;

        for (int problem = 0; problem < answers.length; problem++) {
            int answer = answers[problem];

            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, problem);
                if (answer == picked) {
                    if (++corrects[person] > max) {
                        max = corrects[person];
                    }
                }
            }
        }

        final int maxCorrects = max;
        return IntStream.range(0, 3)
                .filter(i -> corrects[i] == maxCorrects)
                .map(i -> i + 1)
                .toArray();
    }

    // //현재 풀이
    // static int[][] pattern = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
    // static int[] score = new int[3];
    // public int[] solution1(int[] answer){
    //     int max = -1;
    //     for(int i=0; i<answer.length; i++){
    //         if(answer[i]==pattern[0][i%pattern[0].length]) score[0]++;
    //         if(answer[i]==pattern[1][i%pattern[1].length]) score[1]++;
    //         if(answer[i]==pattern[2][i%pattern[2].length]) score[2]++;
    //     }

    //     max = score[0]<score[1] ? score[1] : score[0];
    //     max = max<score[2] ? score[2] : max;

    //     ArrayList<Integer> list = new ArrayList<>();
    //     for(int i=0; i<3; i++){
    //         if(max==score[i]) list.add(i+1);
    //     }

    //     int[] winner = new int[list.size()];
    //     for(int i=0; i<list.size(); i++){
    //         winner[i] = list.get(i);
    //     }
    //     return winner;
    // }

    //이전 풀이
    // public int[] solution(int[] answers) {
    //     int[] sp1 = {1,2,3,4,5};
    //     int[] sp2 = {2,1,2,3,2,4,2,5};
    //     int[] sp3 = {3,3,1,1,2,2,4,4,5,5};
    //     int[] score = new int[3];
    //     for(int i=0; i<answers.length; i++){
    //         if(answers[i]==sp1[i%sp1.length]) score[0]++;
    //         if(answers[i]==sp2[i%sp2.length]) score[1]++;
    //         if(answers[i]==sp3[i%sp3.length]) score[2]++;
    //     }
    //     int max = 0;
    //     int size = 1;
    //     for(int j=0; j<3; j++){
    //         if(max<score[j]) {
    //             max=score[j];
    //             size=1;
    //         } else if(max==score[j]){
    //             size++;
    //         }
    //     }
    //     int[] answer = new int[size];
    //     int j=0;
    //     for(int k=0; k<3; k++){
    //         if(score[k]==max) answer[j++]=k+1;
    //     }
    //     return answer;
    // }
}
