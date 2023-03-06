package Level1.가장가까운같은글자;

import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] visited = new int[26];
        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i)-97;
            if(visited[ch]==0){
                visited[ch] = 1;
                answer[i] = -1;
            } else {
                for(int j=i-1; j>=0; j--){
                    if(s.charAt(j)==s.charAt(i)){
                        answer[i] = i-j;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    //다른 풀이1
    public int[] solution1(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            answer[i] = i-map.getOrDefault(ch,i+1);
            map.put(ch,i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String s = "banana";
        for(int x : T.solution(s)) System.out.print(x+" ");
    }
}