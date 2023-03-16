package Level1.나누어떨어지는숫자배열;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        for(int x : arr){
            if(x%divisor == 0) list.add(x);
        }
        if(list.size()==0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            answer = list.stream()
                        .mapToInt(i -> i)
                        .toArray();
            Arrays.sort(answer);
        }
        
        return answer;
    }

    //다른 풀이1
    public int[] divisible(int[] array, int divisor) {
        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
    }

    //다른 풀이2
    public int[] solution2(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        if(answer.length == 0) answer = new int[] {-1};
        java.util.Arrays.sort(answer);
        return answer;
}
}