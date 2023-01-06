// 5-1.올바른 괄호
import java.util.*;

class STACK_01 {

  //나의 답
  public String solution1(String s){
    int cnt = 0;
    for(char x: s.toCharArray()){
      if(x=='(') cnt++;
      else cnt--;
      if(cnt<0) return "NO";
    }
    if(cnt>0) return "NO";
    return "YES";
  }

  //강의 답
  public String solution2(String str){
    String answer = "YES";
    Stack<Character> stack=new Stack<>();
    for(char x : str.toCharArray()){
      if(x=='(') stack.push(x);
      else{
        if(stack.isEmpty()) return "NO";
        stack.pop();
      }
    }
    if(!stack.isEmpty()) return "NO";
    return answer;
  }

  public static void main(String[] args){
    STACK_01 T = new STACK_01();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(T.solution2(str));
    sc.close();
  }
}