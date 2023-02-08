package Level0.개미군단;

public class Solution {
    public int solution(int hp) {
        int answer = 0, i = 0;
        int[] soldier = {5, 3, 1};
        while(hp>0){
            answer += hp / soldier[i];
            hp %= soldier[i++];
        }
        return answer;
    }

    //다른 풀이1
    public int solution1(int hp) {
        return hp / 5 + (hp % 5 / 3) + hp % 5 % 3;
    }
}
