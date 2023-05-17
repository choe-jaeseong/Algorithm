package 해시.없는숫자더하기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    //강의 답
    public int solution1(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int x : numbers){
            set.add(x);
        }

        int sum = 0;
        for(int i = 0; i <= 9; i++){
            if(set.contains(i)) continue;
            sum += i;
        }
        return sum;
    }

    //나의 답
    public int solution(int[] numbers) {
        int answer = 45;
        for(int x : numbers){
            answer -= x;
        }
        return answer;
    }
}
