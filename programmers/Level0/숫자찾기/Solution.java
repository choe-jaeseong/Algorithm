package Level0.숫자찾기;

public class Solution {
    public int solution(int num, int k) {
        int answer = 0, digit = 1;
        while(num>0){
            int a = num%10;
            if(a==k) answer = digit;
            digit++;
            num/=10;
        }
        if(answer==0) return -1;
        else return digit - answer;
    }

    //다른 풀이1
    public int solution1(int num, int k) {
        return ("-" + num).indexOf(String.valueOf(k));
    }
    //다른 풀이2
    public int solution2(int num, int k) {
        String numStr = String.valueOf(num);
        String kStr = String.valueOf(k);

        int answer = numStr.indexOf(kStr);
        return answer < 0 ? -1 : answer + 1 ;
    }
}
