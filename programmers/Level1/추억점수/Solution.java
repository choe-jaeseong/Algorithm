package Level1.추억점수;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        for(int i=0; i<photo.length; i++){
            for(String x : photo[i]){
                for(int j=0; j<name.length; j++){
                    if(x.equals(name[j])) answer[i]+=yearning[j];
                }
            }
        }
        return answer;
    }
    //다른 풀이1
    public int[] solution1(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = IntStream.range(0, name.length).mapToObj(operand -> Map.entry(name[operand], yearning[operand])).collect(Collectors.toSet()).stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return Arrays.stream(photo).mapToInt(strings -> Arrays.stream(strings).mapToInt(value -> map.getOrDefault(value, 0)).sum()).toArray();
    }
}


