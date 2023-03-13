package Level1.약수의합;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(n%i==0) answer+=i;
        }
        return answer;
    }

    //다른 풀이1
    public int sumDivisor(int num) {
        int answer = 0;
        for(int i =1 ; i<=num/2;i++){
            if(num%i==0){
                answer+=i;
            }
        }
        return answer+num;
    }
}
