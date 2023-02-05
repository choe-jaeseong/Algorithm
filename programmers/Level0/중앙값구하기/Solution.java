package Level0.중앙값구하기;
import java.util.Arrays;
class Solution{
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        answer = array[array.length/2];
        return answer;
    }
}