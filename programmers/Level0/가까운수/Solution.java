package Level0.가까운수;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] array, int n) {
        int answer = 0, diff = 100;
        Arrays.sort(array);
        for(int i=0; i<array.length; i++){
            if(array[i]==n) return n;
            else if(array[i]<n){
                answer = array[i];
                diff = n - array[i];
            } else {
                if(array[i] - n < diff) answer = array[i];
                break;
            }
        }
        return answer;
    }
    //다른 풀이1
    public int solution1(int[] array, int n) {
        int answer = 0;
        Arrays.sort(array);
        for(int i = 1 ; i < array.length ; i++){
            if(Math.abs(n-array[0]) > Math.abs(n-array[i])){
                array[0] = array[i];
            }
        }
        answer = array[0];
        return answer;
    }

    //다른 풀이2
    public int solution2(int[] array, int n) {
        return Math.min(array[Arrays.stream(array).map(operand -> Math.abs(n - operand)).boxed().collect(Collectors.toList()).indexOf(Arrays.stream(array).map(operand -> Math.abs(n - operand)).min().orElse(0))], array[Arrays.stream(array).map(operand -> Math.abs(n - operand)).boxed().collect(Collectors.toList()).lastIndexOf(Arrays.stream(array).map(operand -> Math.abs(n - operand)).min().orElse(0))]);
    }

}
