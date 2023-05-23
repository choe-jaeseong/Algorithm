package 영어끝말잇기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<String> dict = new HashSet<>();
    char last;
    private boolean isCorrect(String word) {
        if (dict.contains(word)) return false;
        if (last != word.charAt(0)) return false;

        dict.add(word);
        last = word.charAt(word.length() - 1);
        return true;
    }

    public int[] solution(int n, String[] words) {
        int index = 0;
        dict.add(words[0]);
        last = words[0].charAt(words[0].length() - 1);
        boolean notExist = true; 

        for(int i = 1; i < words.length; i++) {
            if(!isCorrect(words[i])) {
                notExist = false;
                index = i;
                break;
            }
        }
        
        if(notExist) return new int[]{0,0};
        return new int[]{index % n + 1, index / n + 1};
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        for(int x : T.solution(3, arr)) System.out.print(x + " ");
    }
}
