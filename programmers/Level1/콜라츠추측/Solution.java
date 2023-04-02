package Level1.콜라츠추측;

public class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = (long)num;
        while(n!=1){
            if(answer>500) return -1;
            else{
                answer++;
                if(n%2==0) n/=2;
                else n=n*3+1;
            }
        }
        return answer;
    }
}
