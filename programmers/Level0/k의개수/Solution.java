package Level0.k의개수;

public class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int p=i; p<=j; p++){
            int tmp = p;
            while(tmp>0){
                if(tmp%10==k) answer++;
                tmp/=10;
            }
        }
        return answer;
    }
    
    //다른 풀이1
    public int solution1(int i, int j, int k) {
        String str = "";
        for(int a = i; a <= j; a++) {
            str += a+"";
        }

        return str.length() - str.replace(k+"", "").length();
    }
}
