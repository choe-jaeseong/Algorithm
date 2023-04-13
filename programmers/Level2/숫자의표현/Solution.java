package Level2.숫자의표현;

public class Solution {
    public int solution(int n) {
        int answer = 0;  //가능한 횟수
        int sum=1, lt=1, rt=1;
        if(n<=2) return 1;
        while(lt<=n/2){
            if(sum<n) sum += ++rt;
            else if(sum>n) sum -= lt++;
            else {
                answer++;
                sum+=++rt;
                sum-=lt++;
            }
        }
        answer++;
        return answer;
    }

    //다른 풀이1
    //주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리가 있습니다.
    public int solution1(int num) {
        int answer = 0;
        for (int i = 1; i <= num; i += 2) 
            if (num % i == 0) 
                answer++;

        return answer;
    }
    //다른 풀이2
    public int expressions(int num) {
        int answer = 0;
        for(int i = 1;i<=num;i++){
            int temp = 0;
            for(int j = i;j<=num;j++){
                temp = temp + j;
                if(temp == num){
                    answer++;
                    break;
                }else if(temp>num){
                    break;
                }
            }
        }
        return answer;
    }
}
