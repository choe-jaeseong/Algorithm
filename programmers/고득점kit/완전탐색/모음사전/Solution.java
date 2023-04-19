package 고득점kit.완전탐색.모음사전;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    String ans;
    int cnt = 0;
    int ans_cnt = 0;
    boolean flag = true;
    char[] arr = {'A','E','I','O','U'};
    public void DFS(String word){
        System.out.println(word + " " + cnt);
        if(ans.equals(word)) {
            flag = false;
            ans_cnt=cnt;
            return ;
        }
        if(word.length()==5) return ;
        for(int i=0; i<5; i++){
            cnt++;
            DFS(word+arr[i]);
        }
    }
    public int solution(String word) {
        ans = word;
        DFS("");
        return ans_cnt;
    }

    //다른 풀이1
    List<String> list = new ArrayList<>();
    void dfs(String str, int len) {
        if(len > 5) return;
        list.add(str);
        for(int i = 0; i < 5; i++) dfs(str + "AEIOU".charAt(i), len + 1);
    }
    public int solution1(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }

    //다른 풀이2
    public int solution2(String word) {
        int answer = 0, per = 3905;
        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("I"));
    }
}
