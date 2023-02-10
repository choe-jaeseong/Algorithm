package Level0.배열회전시키기;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        if(direction.equals("right")){
            for(int i=0; i<numbers.length-1; i++){
                answer[i+1]=numbers[i];
            }
            answer[0] = numbers[numbers.length-1];
        } else {
            for(int i=1; i<numbers.length; i++){
                answer[i-1]=numbers[i];
            }
            answer[numbers.length-1] = numbers[0];
        }
        return answer;
    }

    //다른 풀이1
    public int[] solution1(int[] numbers, String direction) {
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        if (direction.equals("right")) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        } else {
            list.add(list.size(), list.get(0));
            list.remove(0);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
