package Level0.순서쌍의개수;

import java.util.stream.IntStream;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(n % i == 0) answer++;
        }
        return answer;
    }

    //다른 풀이
    public int solution1(int n) {
        return (int) IntStream.rangeClosed(1, n).filter(i -> n % i == 0).count();
    }
}
