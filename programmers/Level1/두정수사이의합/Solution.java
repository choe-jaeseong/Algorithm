package Level1.두정수사이의합;

public class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a==b) return (long)a;
        else if(a<b){
            for(int i=a; i<=b; i++){
                answer+=i;
            }
        } else {
            for(int i=b; i<=a; i++){
                answer+=i;
            }
        }
        return answer;
    }

    //다른 풀이1
    public long solution1(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
    
}
