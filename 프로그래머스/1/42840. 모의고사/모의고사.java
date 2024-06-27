import java.util.*;

class Solution {
    private static int[][] pattern = new int[3][];

    public int[] solution(int[] answers) {
        pattern[0] = new int[]{1, 2, 3, 4, 5};
        pattern[1] = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        pattern[2] = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] counts = new int[3];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<answers.length; i++) {
            for(int j=0; j<3; j++) {
                int len = pattern[j].length;
                int submit = pattern[j][i % len];
                if(submit == answers[i]) {
                    counts[j]++;
                    max = max < counts[j] ? counts[j] : max;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++) {
            if(counts[i] == max) {
                list.add(i + 1);
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}