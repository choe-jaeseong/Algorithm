//2. 대소문자 변환
import java.util.*;

class STRING_02 {
    
    public String solution(String str){
        String answer = "";
        for (char x : str.toCharArray()) {
            // if (Character.isLowerCase(x)) answer+=Character.toUpperCase(x);
            // else answer+=Character.toLowerCase(x);
            if(x>=97 && x <=122) answer+=(char)(x-32);
            else answer+=(char)(x+32);
        }
        return answer;
    }
    
    public static void main(String[] args) {
        STRING_02 T = new STRING_02();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
        kb.close();
        return ;
    }
}