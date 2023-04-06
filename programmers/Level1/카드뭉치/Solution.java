package Level1.카드뭉치;

public class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        for(int i=0; i<goal.length; i++){
            if(idx1<cards1.length && goal[i].equals(cards1[idx1])){
                idx1++;
            } else if(idx2<cards2.length && goal[i].equals(cards2[idx2])){
                idx2++;
            } else return "No";
        }
        return "Yes";
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] card1 = {"i", "water", "drink"};
        String[] card2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(T.solution(card1, card2, goal));
    }
}
