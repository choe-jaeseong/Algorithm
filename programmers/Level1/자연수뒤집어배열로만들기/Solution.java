package Level1.자연수뒤집어배열로만들기;

public class Solution {
    public int[] solution(long n) {
        String m = n + "";
        int[] ans = new int[m.length()];
        for(int i=0; i<m.length(); i++){
            ans[i]=m.charAt(m.length()-1-i)-'0';
        }
        return ans;
    }

    //다른 풀이1
    public int[] solution1(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}
