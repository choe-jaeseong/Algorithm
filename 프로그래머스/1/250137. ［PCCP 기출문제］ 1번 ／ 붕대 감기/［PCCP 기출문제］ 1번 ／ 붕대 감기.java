//2시 40분
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int pH = health;
        int time = 0;
        int idx_attack = 0;
        while(idx_attack < attacks.length) {
            int[] attack = attacks[idx_attack];
            
            //공격시간까지 회복 및 추가 회복
            int count = 0;
            while(++time < attack[0]) {
                count++;
                pH += bandage[1];
                if(count % bandage[0] == 0) pH += bandage[2];
                if(pH > health) pH = health;
            }
            
            //공격
            pH -= attack[1];
            if(pH <= 0) return -1;
            idx_attack++;
        }
        
        return pH;
    }
}