package Level0.의7개수;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int x : array){
            int tmp = x;
            while(tmp>0){
                if(tmp%10==7) answer++;
                tmp /= 10;
            }
        }
        return answer;
    }

    //다른 풀이1
    public int solution1(int[] array) {
        return (int) Arrays.stream(
                        Arrays.stream(array)
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining())
                                .split("")
                )
                .filter(s -> s.equals("7"))
                .count();
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1,0,0,7,7};
        System.out.println(T.solution(arr));
    }    
}
