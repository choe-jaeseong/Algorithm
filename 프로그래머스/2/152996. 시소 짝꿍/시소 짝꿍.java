import java.util.*;

class Solution {

    int n;

    public long solution(int[] weights) {
        long answer = 0;

        n = weights.length;

        Map<Integer, Integer> counts = new HashMap<>();

        for(int i = 0; i < n; i++) {
            counts.put(weights[i], counts.getOrDefault(weights[i], 0) + 1);
        }


        int[] countsKeys = counts.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(countsKeys);

        for(int i=0;i<countsKeys.length;i++){
            int left = countsKeys[i];
            long leftCount = counts.get(left);
            if(leftCount > 1) {
                answer += leftCount*(leftCount-1) / 2;
            }
            for(int j=i+1;j<countsKeys.length;j++){
                int right = countsKeys[j];
                long rightCount = counts.get(right);
                if(left*3 == right*2 || left*4 == right*3 || left*2 == right) {
                    answer+=leftCount * rightCount;
                }
            }
        }

        return answer;
    }
}