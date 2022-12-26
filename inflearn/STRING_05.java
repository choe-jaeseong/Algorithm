// 5. 특정 문자 뒤집기(toCharArray())
import java.util.*;

class STRING_05{
    
    public String solution(String str){
        String answer;
        int lt = 0, rt = str.length()-1;
        char[] s = str.toCharArray();
        while (lt < rt){
            if (!Character.isAlphabetic(s[lt])) lt++;
            else if (!Character.isAlphabetic(s[rt])) rt--;
            else{
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer=String.valueOf(s);
        
        return answer;
    }
    
    public static void main(String[] args){
        STRING_05 T = new STRING_05();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
        kb.close();
        return ;
    }
    
}