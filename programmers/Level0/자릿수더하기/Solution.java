package Level0.자릿수더하기;

import java.util.Arrays;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n>0){
            answer+=n%10;
            n/=10;
        }
        return answer;
    }

    //다른 풀이1
    public int solution1(int n) {
        return Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();
    }
    //다른 풀이2
    public int solution2(int n) {
        String[] split = String.valueOf(n).split("");
        return Arrays.stream(split).mapToInt(Integer::parseInt).sum();
    }
    //다른 풀이3
    public int solution3(int n) {
        int answer = 0;
        String str = Integer.toString(n);
        String[] arr = str.split("");

        for(int i = 0; i < arr.length; i++) {
            answer += Integer.parseInt(arr[i]);
        }
        return answer;
    }
}
