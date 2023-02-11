package Level0.소인수분해;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(n%i==0){
                list.add(i);
                while(n%i==0) n/=i;
            }
            if(n==1) break;
        }
        Collections.sort(list);
        int[] arr = list.stream().mapToInt(i->i).toArray();
        return arr;
    }
}
