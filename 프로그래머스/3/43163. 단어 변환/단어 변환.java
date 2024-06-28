import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        if(!isExist(target, words)) return 0;
        boolean[] ch = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, -1, 0));
        
        while(!q.isEmpty()) {
            Word word = q.poll();
            if(word.s.equals(target)) 
                return word.count;
            
            for(int i=0; i<words.length; i++) {
                if(word.index == i) 
                    continue;
                if(!ch[i] && word.haveOneDifference(words[i])) {
                    ch[i] = true;
                    q.add(new Word(words[i], i, word.count + 1));
                }
            }
        }
        return 0;
    }
    
    private static boolean isExist(String target, String[] words) {
        for(String word : words) 
            if(word.equals(target))
                return true;
        
        return false;
    }
    
    class Word {
        String s;
        int index;
        int count;
        
        Word (String s, int index, int count) {
            this.s = s;
            this.index = index;
            this.count = count;
        }
        
        boolean haveOneDifference(String other) {
            int count = 0;
            char[] a = s.toCharArray();
            char[] b = other.toCharArray();
            
            for(int i=0; i<other.length(); i++) {
                if(a[i] != b[i]) count++;
                if(count >= 2) return false;
            }
            return true;
        }
    }
}
/*
1. words 에 target 이 있는지 확인 - return
2. begin 과 한 글자만 다른 녀석이 있는지 확인 -> 가능하면 queue 에 넣기.
*/