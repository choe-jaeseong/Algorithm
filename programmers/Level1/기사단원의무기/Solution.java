package Level1.기사단원의무기;

public class Solution {
    public int getDivisorCount(int n){
        int cnt = 1, i=2;
        if(n==1) return 1;
        while(i*i<=n){
            if(n%i==0) cnt++;
            i++;
        }
        i--;
        if(i*i==n) cnt=cnt*2-1;
        else cnt*=2;
        return cnt;
    }
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            int a = getDivisorCount(i)>limit ? power : getDivisorCount(i);
            answer+=a;
            System.out.println(a);
        }
        return answer;
    }

    //다른 풀이1
    public int count(int N){
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            if (i * i == N) count++;
            else if (N % i == 0) count += 2;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(5, 3, 2));
    }
}
