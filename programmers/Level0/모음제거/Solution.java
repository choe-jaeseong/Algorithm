package Level0.모음제거;

public class Solution {
    public String solution(String my_string) {
        return my_string.replaceAll("[aeiou]", "");
    }

    //다른 풀이
    public String solution1(String my_string) {
        return my_string.replaceAll("a|e|i|o|u", "");
    }
}
