package Stack;
// 5-2. 괄호문자제거
import java.util.*;

public class STACK_02 {

    //나의 답
    public String solution1(String s){
        String ans = "";
        int cnt = 0;
        for(char x: s.toCharArray()){
            if(x=='('){
                cnt++;
            } else if(x==')'){
                cnt--;
            } else if(cnt>0){
                continue;
            } else {
                ans += x;
            }
        }
        
        return ans;
    }

    //강의 답
    public String solution2(String str){
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x: str.toCharArray()){
            if(x=='('){
                while(stack.pop()!='(');
            }
            else stack.push(x);
        }
        for(int i=0; i<stack.size(); i++) answer+=stack.get(i);
        return answer;
    }
    
    public static void main(String[] args) {
        STACK_02 T = new STACK_02();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(T.solution1(s));
        sc.close();
    }
}
