package Level0.n의배수고르기;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int x : numlist){
            if(x%n==0) arr.add(x);
        }
        Integer[] arr1 = new Integer[arr.size()];
        arr1 = arr.toArray(arr1);
        int[] b = Arrays.stream(arr1).mapToInt(Integer::intValue).toArray(); 
        return b;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1,2,3,4,5,6};
        for(int x : T.solution(2, arr)) System.out.print(x + " ");
    }
}
