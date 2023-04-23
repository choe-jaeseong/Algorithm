package 고득점kit.DFS_BFS.단어변환;

import java.util.LinkedList;
import java.util.Queue;

class Word{
    String x;
    int L;
    Word(String x, int L){
        this.x = x;
        this.L = L;
    }
}
public class Solution {
    int[] ch;
    public int countDiffAlphabet(Word tmp, String str2){
        int cnt = 0;
        for(int i=0; i<str2.length(); i++){
            if(tmp.x.charAt(i)!=str2.charAt(i)) cnt++;
        }
        return cnt;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        ch = new int[words.length];
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));
        while(!q.isEmpty()){
            Word tmp = q.poll();
            // System.out.println(tmp.x);
            for(int i=0; i<words.length; i++){
                if(ch[i]==0 && countDiffAlphabet(tmp, words[i])==1){
                    // System.out.println(words[i] + " " + (tmp.L+1));
                    if(words[i]==target) answer = tmp.L+1;
                    ch[i]=1;
                    q.offer(new Word(words[i], tmp.L+1));
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String begin = "hit";
        String target = "cog";
        String[] arr = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(T.solution(begin, target, arr));
    }
}

/*
 * 최단거리 -> BFS
 * 
 * 
 * 
 * 
 * 1. 방문기록 ch[] : 이동횟수 입력
 * 2. Queue 생성
 * 3. Q에 begin 넣기, 깊이 L = 0;
 * 4. while(!isEmpty)
 *      string tmp = poll
 *      L++;
 *      for( 단어 배열 순환 )
 *          if ch 방문한 적 없고, 다른 알파벳 갯수가 1,
 *              ch[i]=L;
 *              Q.offer(i);
 *              if 단어 == target return L;
 */