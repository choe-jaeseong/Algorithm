import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> result = new ArrayList<>();
        for(int i=l; i<=r; i++) {
            if(isCorrect(i)) 
                result.add(i);
        }
        if(result.size() == 0) return new int[]{-1};
        return result.stream().mapToInt(i->i).toArray();
    }
    private static boolean isCorrect(int i) {
        char[] num = String.valueOf(i).toCharArray();
        for(char c : num) {
            if(!(c == '0' || c == '5'))
                return false;
        }
        return true;
    }
}