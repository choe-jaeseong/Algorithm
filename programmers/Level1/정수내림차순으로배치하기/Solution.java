package Level1.정수내림차순으로배치하기;

import java.util.Arrays;

public class Solution {
    public long solution(long n) {
        char[] arr = (n+"").toCharArray();
        Arrays.sort(arr);
        String sb = new StringBuilder().append(arr).reverse().toString();
        return Long.parseLong(sb);
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(102));
    }
}
