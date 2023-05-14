package 정렬.두개뽑아서더하기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 1. 중복 없이 -> Set
 * 2. 만들고
 * 3. 정렬하기 -> sorted
 */
public class Solution {
    public int[] solution(int[] numbers){
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0;  j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
