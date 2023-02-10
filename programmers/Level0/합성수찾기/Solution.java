package Level0.합성수찾기;

import java.util.stream.IntStream;

public class Solution {
    public boolean is_composite(int n){
        for(int i=2; i<n; i++){
            if(n%i==0) return true;
        }
        return false;
    }
    public int solution(int n) {
        int answer = 0;
        for(int i=4; i<=n; i++){
            if(is_composite(i)) answer++;
        }
        return answer;
    }


    //다른 풀이1
    public int solution1(int n) {
        return (int) IntStream.rangeClosed(1, n).filter(i -> (int) IntStream.rangeClosed(1, i).filter(i2 -> i % i2 == 0).count() > 2).count();
    }
}
