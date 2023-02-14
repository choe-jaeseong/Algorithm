package Level0.캐릭터의좌표;

public class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        int margin_x = (board[0]-1)/2;
        int margin_y = (board[1]-1)/2;
        for(String x : keyinput){
            if(x.equals("right") && answer[0]>= -1 * margin_x) answer[0]++;
            else if(x.equals("left") && answer[0]<= margin_x) answer[0]--;
            else if(x.equals("up") && answer[1]>= -1 * margin_y) answer[1]++;
            else if(x.equals("down") && answer[1]<= margin_y) answer[1]--;
            else continue;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] keyinput = {"left", "right", "up", "right", "right"};
        int[] arr = {11, 11};
        for(int x : T.solution(keyinput, arr)) System.out.println(x);
    }
}
