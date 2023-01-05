// 3. 크레인 인형뽑기(카카오)
import java.util.Scanner;
import java.util.Stack;


public class STACK_03 {

    //나의 답
    public int solution1(int n, int m, int[][] bd, int[] move){
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int x : move){
            for(int i=0; i<n; i++){
                if(bd[i][x-1]==0) continue;
                else if (stack.empty()) stack.push(bd[i][x-1]);
                else if (stack.peek()==bd[i][x-1]) {
                    stack.pop();
                    ans++;
                } else stack.push(bd[i][x-1]);
                bd[i][x-1] = 0;
                break;
            }
        }
        return ans * 2;
    }

    //강의 답
    public int solution2(int[][] bd, int[] move){
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int x : move){
            for(int i=0; i<bd.length; i++){
                if(bd[i][x-1]!=0){
                    int tmp=bd[i][x-1];
                    bd[i][x-1]=0;
                    if(!stack.isEmpty() && tmp==stack.peek()) {
                        ans+=2;
                        stack.pop();
                    }
                    else stack.push(tmp);
                    break;
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        STACK_03 T = new STACK_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]=sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] move = new int[m];
        for(int i=0; i<m; i++){
            move[i]=sc.nextInt();
        }
        System.out.println(T.solution1(n,m,board,move));
        sc.close();
    }
}
