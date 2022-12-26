// 10. 가장 짧은 문자거리
import java.util.*;

class Main{

  public int[] solution(String s, char t){
    int[] dist = new int[s.length()];
    int p = 1000;
    for (int i = 0; i < s.length(); i++){
      if(s.charAt(i)==(t)){
        p = 0;
        dist[i]=p;
      }
      else {
        p++;
        dist[i] = p;
      }
    }
    p = 1000;
    for (int j = s.length()-1; j >= 0; j--){
      if(s.charAt(j)==t) p = 0;
      else{
        p++;
        dist[j] = Math.min(dist[j], p);
      }
    }
    return dist;
  }
  
  public static void main(String[] args){
    Main T = new Main();
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    char t = sc.next().charAt(0);
    for(int x : T.solution(s,t)){
      System.out.print(x+" ");
    }
    return ;
  }
  
}