package Level1.두개뽑아서더하기;

import java.util.TreeSet;

public class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> tset = new TreeSet<>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                tset.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = new int[tset.size()];
        int i=0;
        for(int x : tset){
            answer[i++]=x;
        }
        return answer;
    }
}
