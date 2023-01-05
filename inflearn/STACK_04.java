import java.util.Scanner;
import java.util.Stack;

public class STACK_04 {

    //나의 답
    public int solution1(String str){
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(char x: str.toCharArray()){
            if(x >=48 && x <= 57) stack.push(x - '0');
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(x=='+') stack.push(lt+rt);
                else if(x=='-') stack.push(lt-rt);
                else if(x=='/') stack.push(lt/rt);
                else if(x=='*') stack.push(lt*rt);
            }
        }
        ans = stack.get(0);
        return ans;
    }

    //강의 답
    public int solution2(String str){
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(char x: str.toCharArray()){
            if(Character.isDigit(x)) stack.push(x - '0');
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(x=='+') stack.push(lt+rt);
                else if(x=='-') stack.push(lt-rt);
                else if(x=='/') stack.push(lt/rt);
                else if(x=='*') stack.push(lt*rt);
            }
        }
        ans = stack.get(0);
        return ans;
    }
    
    public static void main(String[] args) {
        STACK_04 T = new STACK_04();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution2(str));
        sc.close();
    }
}
