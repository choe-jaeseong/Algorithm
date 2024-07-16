import java.util.*;

class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        int mode = 0;
        char[] chars = code.toCharArray();
        for(int i=0; i<chars.length; i++) {
            if(chars[i] == '1') {
                mode = 1 - mode;
            } else if (mode == 0) {
                if(i % 2 == 0) {
                    sb.append(chars[i]);
                }                
            } else {
                if(i % 2 == 1) {
                    sb.append(chars[i]);
                } 
            }
        }
        return sb.toString().equals("") ? "EMPTY" : sb.toString();
    }
}