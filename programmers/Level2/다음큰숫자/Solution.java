package Level2.다음큰숫자;

public class Solution {
    public int cnt_one(int binary){
        return Integer.bitCount(binary);
    }
    public int solution(int n) {
        int cnt_1 = cnt_one(n);
        int a = n + 1;
        while(true){
            if(cnt_1==cnt_one(a)) return a;
            else a++;
        }
    }

    //다른 풀이1
    public int nextBigNumber(int n) {
        int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }
}
