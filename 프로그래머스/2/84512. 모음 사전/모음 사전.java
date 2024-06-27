import java.util.*;

class Solution {
    private static final char[] chars = "AEIOU".toCharArray();
    
    public int solution(String word) {
        return generate("").indexOf(word);
    }
    
    private static List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);
        
        if(word.length() == 5) return words;
        
        for(char c : chars) {
            words.addAll(generate(word + c));
        }
        return words;
    }
}