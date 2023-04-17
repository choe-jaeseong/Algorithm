package 고득점kit.Sort.가장큰수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution{
    public String solution(int[] numbers){
        String[] arr = new String[numbers.length];
        for(int i=0; i<arr.length; i++){
            arr[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1,o2)->(o2+o1).compareTo(o1+o2));     //Keypoint!!!!
        
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            ans.append(arr[i]);
        }
        if(ans.toString().charAt(0)=='0') return "0";
        return ans.toString();
    }

    //다른 풀이1
    public String solution1(int[] numbers) {
        String[] nums = new String[numbers.length];

        for (int i=0; i<nums.length; i++) 
            nums[i] = numbers[i] + "";

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        String ans = "";
        for (int i=0; i<numbers.length; i++)
            ans += nums[i];

        return ans.charAt(0) == '0' ? "0" : ans;
    }
    
    //다른 풀이2
    public String solution2(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(T.solution(arr));
    }
}
