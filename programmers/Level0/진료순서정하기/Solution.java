package Level0.진료순서정하기;

import java.util.Arrays;

public class Solution {
    public int find_order(int x, int[] arr){
        int ans = -1;
        int len = arr.length;
        for(int i=0; i<len; i++){
            if(arr[i]==x) return len - i;
        }
        return ans;
    }
    
  public int[] solution(int[] emergency) {
      int len = emergency.length;
      int[] answer= new int[len];
      int[] order= emergency.clone();

      Arrays.sort(order);
      for(int i=0; i<len; i++){
          answer[i]=find_order(emergency[i], order);
      }
      return answer;
  }
}
