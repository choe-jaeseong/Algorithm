import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (a, b) -> {
            if(a[col - 1] == b[col - 1]) {
                return b[0] - a[0]; //내림차순
            }
            return a[col - 1] - b[col - 1]; //오름차순
        });
        
        for(int i=row_begin - 1; i<=row_end - 1; i++) {
            int result = cal(i + 1, data[i]);
            answer ^= result;
        }
        return answer;
    }
    private static int cal(int i, int[] arr) {
        int sum = 0;
        for(int x : arr) {
            sum += x % i;
        }
        return sum;
    }
}