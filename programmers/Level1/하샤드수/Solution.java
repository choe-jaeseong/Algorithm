package Level1.하샤드수;

public class Solution {
    public boolean solution(int x) {
        int tmp = x;
        int sum_x = 0;
        while(tmp>0){
            sum_x += tmp%10;
            tmp /= 10;
        }
        if(x%sum_x==0) return true;
        return false;
    }

    //다른 풀이1
    public boolean isHarshad(int num){
        String [] tmp = String.valueOf(num).split("");
        int sum=0;
        for(String s:tmp) {
            sum+=Integer.parseInt(s);
        }    
        if(num%sum==0) {
            return true;
        } else {
            return false;
        }
    }
    //다른 풀이2
    public boolean solution2(int x) {
        int sum = String.valueOf(x).chars().map(ch -> ch - '0').sum();
        return x % sum == 0;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(123));
    }
}
