import java.util.*;

class INT_04{

  public int[] solution(int n){
    int[] ans = new int[n];
    ans[0] = 1;
    ans[1] = 1;
    for (int i = 2; i < n; i++){
      ans[i] = ans[i-1] + ans[i-2];
    }
    return ans; 
  }

  public static void main(String[] args){
    INT_04 T = new INT_04();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(int x: T.solution(n)){
      System.out.print(x+" ");
    }
    sc.close();
    return ;
  }
}