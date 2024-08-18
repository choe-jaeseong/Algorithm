import java.util.*;

class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        String sub = my_string.substring(s, e + 1);
        System.out.println(sub);
        return my_string.substring(0, s) 
            + sb.append(sub).reverse().toString()
            + my_string.substring(e + 1);
    }
}