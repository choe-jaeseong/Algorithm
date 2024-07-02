import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numbersToString = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            numbersToString[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numbersToString, (s1, s2) -> {
            int original = Integer.parseInt(s1 + s2);
            int reversed = Integer.parseInt(s2 + s1);
            return reversed - original;
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbersToString.length; i++) {
            sb.append(numbersToString[i]);
        }
        return sb.toString().replaceAll("^0+", "0");
    }
}