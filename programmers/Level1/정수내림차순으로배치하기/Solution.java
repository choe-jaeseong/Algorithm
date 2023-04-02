package Level1.정수내림차순으로배치하기;

import java.util.Arrays;

public class Solution {
    public long solution(long n) {
        char[] arr = (n+"").toCharArray();
        Arrays.sort(arr);
        String sb = new StringBuilder().append(arr).reverse().toString();
        return Long.parseLong(sb);
    }
    
    //다른 풀이1
    String res = "";
    public int reverseInt(int n){
        res = "";
        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
        return Integer.parseInt(res);
    }


}
