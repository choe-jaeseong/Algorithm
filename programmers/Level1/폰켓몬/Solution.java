package Level1.폰켓몬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        TreeSet<Integer> tset = new TreeSet<>();
        for(int x : nums){
            tset.add(x);
        }
        answer = tset.size()<nums.length/2 ? tset.size(): nums.length/2;
        return answer;
    }

    //다른 풀이1
    public int solution1(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }
    //다른 풀이2
    public int solution2(int[] nums) {
        //1. 기존 length를 구한다.
        //2. 중복값을 제거한 length를 구한다.
        //3. 두 값중 최소값이 정답.
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }

        return nums.length/2 > list.size()?list.size():nums.length/2;
    }
}
