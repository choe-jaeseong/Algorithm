package String;
//3.문장 속 단어(split, indexof, substring)
import java.util.*;

class STRING_03 {
    
    public String solution(String str){
        String answer = "";
        int m=Integer.MIN_VALUE, pos;
        // String[] s = str.split(" ");     //split
        // for (String x : s){
        //     int len=x.length();
        //     if(len>m){
        //         m=len;
        //         answer=x;
        //     }
        // }
        while((pos=str.indexOf(" "))!=-1){      //indexof
            String tmp=str.substring(0, pos);   //substring
            int len = tmp.length();
            if (len > m){
                m = len;
                answer = tmp;
            }
            str=str.substring(pos+1);
        }
        if (str.length()>m) answer=str;
        return answer;
    }
    
    public static void main(String[] args){
        STRING_03 T = new STRING_03();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.print(T.solution(str));
        kb.close();
        return ;
    }
}