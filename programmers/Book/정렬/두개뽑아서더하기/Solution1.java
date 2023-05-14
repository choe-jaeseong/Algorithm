package 정렬.두개뽑아서더하기;

import java.util.HashSet;
import java.util.Set;

/*
 * 1. 두 수를 뽑아 더한다.
 * 2. 중복이 되지 않고   -> Set<Integer>
 * 3. 오름차순으로 정렬  ->  Arrays.sort
 *  
*/
public class Solution1 {
    public int[] solution(int[] numbers){
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i+1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(i->i).toArray();
    }
}
