// 2. 괄호문자제거
import java.util.*;

public class STACK_02 {

    public String solution(String s){
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
    
    public static void main(String[] args) {
        STACK_02 T = new STACK_02();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(T.solution(s));
        sc.close();
    }
}
