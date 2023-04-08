package Level1.성격유형검사하기;

import java.util.HashMap;

public class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        char[] type = {'R','T','C','F','J','M','A','N'};
        for(int i=0; i<8; i++)
            map.put(type[i], 0);
        for(int i=0; i<survey.length; i++){
            String x = survey[i].toUpperCase();
            int score = choices[i]-4;
            if(score>0) map.put(x.charAt(1),map.get(x.charAt(1))+score);
            else if(score<0) map.put(x.charAt(0),map.get(x.charAt(0))-score);
        }
        for(Character x : map.keySet()){
            System.out.println(x + ": "+map.get(x));
        }
        for(int i=0; i<8; i+=2){
            if(map.get(type[i])<map.get(type[i+1])) answer+=type[i+1];
            else answer+=type[i];
        }
        return answer;
    }
    //다른 풀이1
    public String solution1(String[] survey, int[] choices) {
        String answer = "";
        char [][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int [] score = {0, 3, 2, 1, 0, 1, 2, 3};
        HashMap<Character, Integer> point = new HashMap<Character, Integer>();

        // 점수 기록할 배열 초기화 
        for (char[] t : type) {
            point.put(t[0], 0);
            point.put(t[1], 0);
        }

        // 점수 기록 
        for (int idx = 0; idx < choices.length; idx++){
            if(choices[idx] > 4){
                point.put(survey[idx].charAt(1), point.get(survey[idx].charAt(1)) + score[choices[idx]]);
            } else {
                point.put(survey[idx].charAt(0), point.get(survey[idx].charAt(0)) + score[choices[idx]]);
            }
        }

        // 지표 별 점수 비교 후 유형 기입
        for (char[] t : type) {
            answer += (point.get(t[1]) <= point.get(t[0])) ? t[0] : t[1];
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr = {"TR", "RT", "TR"};
        int[] arr2 = {7,1,3};
        System.out.println(T.solution(arr, arr2));
    }
}
