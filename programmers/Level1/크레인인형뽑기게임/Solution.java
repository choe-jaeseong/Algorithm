package Level1.크레인인형뽑기게임;

import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int x : moves){
            x--;
            for(int i=0; i<board.length; i++){
                if(board[i][x]==0) continue;
                else{
                    if(!stack.isEmpty()){
                        if(stack.peek()==board[i][x]){
                            stack.pop();
                            answer++;
                        } else stack.push(board[i][x]);
                    } else stack.push(board[i][x]);
                    board[i][x]=0;
                    break;
                }
            }
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board.length; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            for(int t : stack) System.out.print(t + " ");
            System.out.println();
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(T.solution(board, moves));
    }
}
