package Level0.A로B만들기;

import java.util.Arrays;

public class Solution {
    public int solution(String before, String after) {
        char[] arr_before = before.toCharArray();
        char[] arr_after = after.toCharArray();
        Arrays.sort(arr_before);
        Arrays.sort(arr_after);
        String strB = new String(arr_before);
        String strA = new String(arr_after);
        if(strA.equals(strB)) return 1;
        else return 0;
    }

    //다른 풀이1
    public int solution1(String before, String after) {
        char[] a = before.toCharArray();
        char[] b = after.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return new String(a).equals(new String(b)) ? 1 :0;
    }
}