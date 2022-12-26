// 9. 숫자만 추출
import java.util.*;

class Main {

  public int solution1(String str){
    int answer = 0;
    for(char x : str.toCharArray()){
      if (x>=48 && x<=57) answer=answer*10 + (x-48);
    }
    return answer;
  }

  public int solution2(String str){
    String answer = "";
    for(char x : str.toCharArray()){
      if (Character.isDigit(x)) answer += x;
    }
    return Integer.parseInt(answer);
  }
  
  public static void main(String[] args){
    Main T = new Main();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(T.solution2(str));
    sc.close();
    return ;
  }
  
}