package Level0.배열뒤집기;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(int[] num_list) {
        int lt=0, rt=num_list.length-1;
        while(lt<rt){
            int tmp = num_list[lt];
            num_list[lt] = num_list[rt];
            num_list[rt] = tmp;
            lt++;
            rt--;
        }
        return num_list;
    }

    //다른사람풀이1
    public int[] solution1(int[] numList) {
        List<Integer> list = Arrays.stream(numList).boxed().collect(Collectors.toList());

        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    //다른사람풀이2
    public int[] solution2(int[] num_list) {
        int[] answer = new int[num_list.length];
        for(int i = 0; i< num_list.length; i++){
            answer[i] = num_list[num_list.length-i-1];
        }
        return answer;
    }
}
