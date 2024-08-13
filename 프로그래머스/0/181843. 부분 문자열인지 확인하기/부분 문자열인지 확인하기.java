import java.util.*;

class Solution {
    public int solution(String my_string, String target) {
        String remove = my_string.replaceAll(target, "");
        return my_string.equals(remove) ? 0 : 1;
    }
}