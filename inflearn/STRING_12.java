// 12. 암호
import java.util.*;

class STRING_12{

  public String solution(int n, String str){
    String answer = "";
    for (int i = 0; i < n; i++){
      String tmp = str.substring(0,7).replace("#", "1").replace("*", "0");
      int num = Integer.parseInt(tmp, 2);
      answer += (char)num;
      str = str.substring(7); 
    }
    return answer;
  }

  public static void main(String[] args){
    STRING_12 T = new STRING_12();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String str = sc.next();
    System.out.println(T.solution(n, str));
    sc.close();
    return ;
  }
}