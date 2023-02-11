package Level0.문자열정렬하기2;

import java.util.Arrays;

public class Solution {
    public String solution(String my_string) {
        char[] arr = new char[my_string.length()];
        for(int i=0; i<my_string.length(); i++){
            arr[i] = Character.toLowerCase(my_string.charAt(i));
        }
        Arrays.sort(arr);
        
        return new String(arr);
    }
    
    //다른 풀이1
    public String solution1(String my_string) {
        char[] c = my_string.toLowerCase().toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
