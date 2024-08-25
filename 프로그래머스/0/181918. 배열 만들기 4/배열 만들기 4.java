import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        int index = 0;
        for(int i = 0;  i < arr.length;) {
            if(stk.length == 0) {
                stk = new int[1];
                stk[index++] = arr[i];
                i++;
            } else {
                if(stk[stk.length-1] < arr[i]) {
                    stk = Arrays.copyOf(stk, stk.length+1);
                    stk[stk.length-1] = arr[i];
                    i++;
                } else {
                    stk = Arrays.copyOf(stk, stk.length-1);
                    index--;
                    if(index < 0) {
                        index = 0;
                    }
                }
            }
        }
        return stk;
    }
}