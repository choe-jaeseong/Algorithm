package 고득점kit.정렬.가장큰수;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution{
    public String solution(int[] numbers){
        String[] arr = new String[numbers.length];
        for(int i=0; i<arr.length; i++){
            arr[i]=String.valueOf(numbers[i]);
        }
        for(int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
        Arrays.sort(arr, (o1,o2)->(o1+o2).compareTo(o2+o1));
        System.out.println();
        for(int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
        
        
        
        return "";
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(T.solution(arr));
    }
}
