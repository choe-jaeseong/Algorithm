package Book.정렬.H_Index;

/*
* 1. citation을 정렬
* 2. h 가능성이 있는 최댓값은 citation의 길이이므로
*    최댓값부터 1까지 차례로 확인
* 3. isValid() : citation, h 주면, [length - h] 인덱스의 값이 h 이상이면 true
*/
import java.util.Arrays;

public class Solution1 {
    private boolean isValid(int[] citations, int h){
        int index = citations.length - h;
        if(citations[index]>=h) return true;
        return false;
    }
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        for(int h = citations.length; h >= 1; h--){
            if(isValid(citations, h)) return h;
        }

        return 0;
    }
}
