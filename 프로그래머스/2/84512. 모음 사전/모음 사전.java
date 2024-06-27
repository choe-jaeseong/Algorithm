import java.util.*;

class Solution {
    private static final char[] chars = "AEIOU".toCharArray();
    
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }
    
    private static void generate(String word, List<String> words) {
        words.add(word);
        
        if(word.length() == 5) return;
        for(char c : chars) {
            generate(word + c, words);
        }
    }
}