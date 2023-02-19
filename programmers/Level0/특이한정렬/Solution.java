package Level0.특이한정렬;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    //다른 풀이1
    public int[] solution1(int[] numlist, int n) {
        Integer[] arr = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                int a = Math.abs(o1-n);
                int b = Math.abs(o2-n);
                if(a == b)
                    return o2 - o1;
                return a - b;
            }
        });
        return Arrays.stream(arr).mapToInt(i->i).toArray();
    }

    //다른 풀이2
    public int[] solution2(int[] numList, int n) {
        return Arrays.stream(numList)
                .boxed()
                .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    //다른 풀이3
    public int[] solution(int[] numlist, int n) {
        int size = numlist.length;
        for(int i=0; i<size-1; i++){
            for(int k=i+1; k<size; k++){
                int a = (numlist[i] - n) * (numlist[i] > n ? 1 : -1);
                int b = (numlist[k] - n) * (numlist[k] > n ? 1 : -1);
                if(a > b || (a == b && numlist[i] < numlist[k])){
                    int temp = numlist[i];
                    numlist[i] = numlist[k];
                    numlist[k] = temp;
                }

            }
        }
        return numlist;
    }
}
