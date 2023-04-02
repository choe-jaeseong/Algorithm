package Level1.최대공약수와최소공배수;

public class Solution {
    public int Find_gcd(int n, int m){
        int ans;
        ans = n>m ? m : n;
        for(; ans>=1; ans--){
            if(n%ans==0 && m%ans==0) break;
        }
        return ans;
    }
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = Find_gcd(n, m);
        answer[1] = n * m / Find_gcd(n, m);
        return answer;
    }


    //다른 풀이1
    public int[] gcdlcm(int a, int b) {
        int[] answer = new int[2];
        answer[0] = gcd(a,b);
        answer[1] = (a*b)/answer[0];
        return answer;
    }

    public static int gcd(int p, int q){
        if (q == 0) return p;
        return gcd(q, p%q);
   }
}
