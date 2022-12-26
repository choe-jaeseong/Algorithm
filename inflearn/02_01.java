import java.util.*;

class Main{

  public void solution(int cnt, int[] num){
    int i = 0;
    System.out.print(num[i]+" ");
    while (i < cnt){
      if (num[i] < num[i+1])
        System.out.print(num[i+1]+" ");
      i++;
    }
    return ;
  }

  public static void main(String[] args){
    Main T = new Main();
    Scanner sc = new Scanner(System.in);
    int[] num = new int[100];
    int cnt = sc.nextInt();
    for (int i=0; i < cnt; i++){
      num[i] = sc.nextInt();
    }
    T.solution(cnt, num);
    return ;
  }
}
