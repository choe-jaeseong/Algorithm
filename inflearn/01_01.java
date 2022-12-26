//1. 문자 찾기
import java.util.*;

class Main {
    
    public int solution(String str, char t){
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        // for(int i = 0; i<str.length(); i++)
        //     if(str.charAt(i)==t) answer++;
        for(char x : str.toCharArray()){
            if(x==t) answer++;
        }
        return answer;
    }
    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.print(T.solution(str, c));
        kb.close();
        return ;
    }
}