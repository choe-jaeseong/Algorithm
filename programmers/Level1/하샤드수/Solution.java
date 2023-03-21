package Level1.하샤드수;

public class Solution {
    public boolean solution(int x) {
        int tmp = x;
        int sum_x = 0;
        while(tmp>0){
            System.out.println("sum_x: "+sum_x+", tmp: "+tmp+", x: "+x);
            sum_x += x%10;
            tmp /= 10;
            System.out.println("sum_x: "+sum_x+", tmp: "+tmp+", x: "+x);
        }
        if(x%sum_x==0) return true;
        return false;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(123));
    }
}
