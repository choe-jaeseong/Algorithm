// 5-5. 쇠막대기
import java.util.Scanner;
import java.util.Stack;

public class STACK_05 {

    public int solution(String s){
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') stack.push('(');
            else{
                stack.pop();
                if(s.charAt(i-1)=='(') ans+=stack.size();
                else ans++;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        STACK_05 T = new STACK_05();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(T.solution(s));
    }
}
