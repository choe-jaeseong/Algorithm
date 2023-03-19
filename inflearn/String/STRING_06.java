package String;
// 6. 중복문자제거
import java.util.*;

class STRING_06{
    
    public String solution(String str){
        String answer = "";
        for (int i=0; i<str.length(); i++) {
            if (str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);
        }
        
        return answer;
    }
    
    public static void main(String[] args){
        STRING_06 T = new STRING_06();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
        sc.close();
        return ;
    }
}