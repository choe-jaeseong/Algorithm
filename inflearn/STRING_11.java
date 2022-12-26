// 11. 문자열 압축
import java.util.*;

class STRING_11{

  public String solution(String str){
    String answer = "";
    int cnt = 1;
    char[] s = str.toCharArray(); 
    answer += s[0];
    for (int i = 1; i < str.length(); i++){
      if(s[i]==s[i-1]) {
        cnt++;
        if(i==str.length()-1) answer += cnt;
        continue;
      } else {
        if (cnt != 1) answer += cnt;
        answer += s[i];
        cnt = 1;
      }
    }
    return answer;
  }

  
  public static void main(String[] args){
    STRING_11 T = new STRING_11();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.print(T.solution(str));
    sc.close();
    return ;
  }
}

/*
 * import java.util.*;

public class Main{

  public String solution(String str){
    String answer = "";
		s=s+" ";
		int cnt = 1;
		for (int i = 0; i<s.length()-1; i++){
			if(s.charAt(i)==s.charAt(i+1)) cnt++;
			else{
				answer+=s.charAt(i);
				if(cnt>1) answer+=String.valueOf(cnt);
				cnt=1;
			}
		}
    return answer;
  }

  
  public static void main(String[] args){
    Main T = new Main();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.print(T.solution(str));
    return ;
  }
}
 */