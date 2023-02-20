package Level1.나머지가1이되는수찾기;

import java.util.stream.IntStream;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=2; i<n; i++){
            if(n%i==1) return i;
        }
        return answer;
    }

    //다른 풀이1
    public int solution1(int n) {
        return IntStream.range(2, n).filter(i -> n % i == 1).findFirst().orElse(0);
    }
}
