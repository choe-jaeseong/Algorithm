package Level0.캐릭터의좌표;

public class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        int margin_x = (board[0]-1)/2;
        int margin_y = (board[1]-1)/2;
        for(String x : keyinput){
            if(x.equals("right") && answer[0] < margin_x) answer[0]++;
            else if(x.equals("left") && answer[0] > -1 * margin_x) answer[0]--;
            else if(x.equals("up") && answer[1] < margin_y) answer[1]++;
            else if(x.equals("down") && answer[1] > -1 * margin_y) answer[1]--;
            else continue;
        }
        return answer;
    }

    //다른 풀이1
    public int[] solution1(String[] keyinput, int[] board) {
        int[] now = {0, 0};
        for (int i = 0; i < keyinput.length; i++){
            if(keyinput[i].equals("left")) now[0] -= now[0]>-(board[0]/2)?1:0;
            else if(keyinput[i].equals("right")) now[0] += now[0]<(board[0]/2)?1:0;
            else if(keyinput[i].equals("down")) now[1] -= now[1]>-(board[1]/2)?1:0;
            else if(keyinput[i].equals("up")) now[1] += now[1]<(board[1]/2)?1:0;
            }
        return now;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] keyinput = {"left", "right", "up", "right", "right"};
        int[] arr = {11, 11};
        for(int x : T.solution(keyinput, arr)) System.out.println(x);
    }
}


//다른풀이1
class Solution1 {
    private String up = "up";
    private String down = "down";
    private String left = "left";
    private String right = "right";
    private int xPos = 0;
    private int yPos = 1;
    private int maxWidth = 0;
    private int maxHeight= 0;
    int[] answer = {0, 0};

    public int[] solution(String[] keyinput, int[] board) {
        maxWidth = board[xPos] / 2;
        maxHeight = board[yPos] / 2;
        for (String moveKey : keyinput) {
            move(moveKey);
        }
        return answer;
    }

    private void move(String key) {
        if (up.equals(key)) {
            // up
            moveUp();
        } else if (down.equals(key)) {
            // down
            moveDown();
        } else if (left.equals(key)) {
            // left
            moveLeft();
        } else {
            // right
            moveRight();
        }
    }

    private void moveUp() {
        int top = Math.abs(maxHeight);
        if (answer[yPos] + 1 <= top) {
            answer[yPos]++;
        };
    }

    private void moveDown() {
        int bottom = Math.abs(maxHeight) * -1;
        if (answer[yPos] - 1 >= bottom) {
            answer[yPos]--;
        };
    }

    private void moveLeft() {
        int left = Math.abs(maxWidth) * -1;
        if (answer[xPos] - 1 >= left) {
            answer[xPos]--;
        };
    }

    private void moveRight() {
        int right = Math.abs(maxWidth);
        if (answer[xPos] + 1 <= right) {
            answer[xPos]++;
        };
    }
}
