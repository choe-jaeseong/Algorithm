// 7. 회문 문자열
import java.util.*;

class STRING_07{
    
    public String solution(String str){
        int i=0, j=str.length()-1;
				str = str.toUpperCase();
        while(i < j){
            if(str.charAt(i) != str.charAt(j)) return "NO";
            i++;
            j--;
        }
        return "YES";
    }
    
    public static void main(String[] args){
        STRING_07 T = new STRING_07();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
        sc.close();
        return ;
    }
}