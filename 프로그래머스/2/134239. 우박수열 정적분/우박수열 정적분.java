import java.util.*;

class Solution {
    
    public double[] solution(int k, int[][] ranges) {
        List<Double> acc = makingAccList(k);
        return findResult(acc, ranges);
    }
    private static double[] findResult(List<Double> acc, int[][] ranges) {
        double[] answer = new double[ranges.length];
        for(int i=0; i<ranges.length; i++) {
            int start = ranges[i][0];
            int end = acc.size() - 1 + ranges[i][1];
            if(end == start) answer[i] = 0.0;
            else if(end < start) answer[i] = -1.0;
            else answer[i] = acc.get(end) - acc.get(start);
        }
        return answer;
    }
    private static List<Double> makingAccList(int k) {
        List<Integer> list = new ArrayList<>();
        List<Double> acc = new ArrayList<>();
        
        list.add(k);
        
        while(k > 1) {
            if(k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            list.add(k);
        }
        
        acc.add(0.0);
        for(int i=1; i<list.size(); i++) {
            double area = (double) (list.get(i-1) + list.get(i)) / (double) 2;
            acc.add(acc.get(i-1) + area);
        }
        
        return acc;
    }
}