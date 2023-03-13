package Level1.소수찾기;

public class Solution {
    boolean isPrime(int x){
        for(int i=2; i*i<=x; i++){
            if(x%i==0) return false;
            else continue;
        }
        return true;
    }

    public int solution(int n) {
        int answer = 0;
        for(int i=2; i<=n; i++){
            if(isPrime(i)) answer++;
        }
        return answer;
    }

    //다른 풀이1
    int numberOfPrime1(int n) {
        int result = 0;
        for(int i=2; i<=n; i++){
            for(int j=2; j<=i; j++){
                if(j == i){
                    ++result;
                } else if(i%j == 0){
                    break;
                }
            }
        }
        return result;
    }

    //다른 풀이2
    int numberOfPrime2(int n) {
        int result = 0;
        int check =0;
    // 함수를 완성하세요.
    for(int i=1; i<=n; i++){
          for(int j = 1; j<=i; j++){
          if(i%j == 0){
            check++;
          }
      }
      if(check ==2)
                result++;
      check=0;
    }

        return result;
    }
}
