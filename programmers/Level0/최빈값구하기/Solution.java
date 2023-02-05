package Level0.최빈값구하기;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution1(int[] array) {
        int answer=0, cnt=0;
        int[] check = new int[1000];
        for(int i=0; i<array.length; i++){
            check[array[i]]++;
            if(check[array[i]]>cnt){
                cnt = check[array[i]];
                answer = array[i];
            }
        }
        int cnt2 = 0;
        for(int i=0; i<1000; i++){
            if(check[i]==cnt) cnt2++;
            if(cnt2==2) return -1;
        }
        return answer;
    }

    //다른 사람 풀이
    public int solution2(int[] array) {
        int maxCount = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : array){
            int count = map.getOrDefault(number, 0) + 1;
            if(count > maxCount){
                maxCount = count;
                answer = number;
            }
            else  if(count == maxCount){
                answer = -1;
            }
            map.put(number, count);
        }
        return answer;
    }
}
