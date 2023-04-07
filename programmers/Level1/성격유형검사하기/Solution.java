package Level1.성격유형검사하기;

import java.util.HashMap;
import java.util.Map;

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
            System.out.println(i + " " +x+ " "+score);
            if(score>0) {
                map.put(x.charAt(1),map.get(x.charAt(1))+score);
            }else if(score<0) {
                map.put(x.charAt(0),map.get(x.charAt(0))-score);
            }
            
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
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr = {"TR", "RT", "TR"};
        int[] arr2 = {7,1,3};
        System.out.println(T.solution(arr, arr2));
    }
}
