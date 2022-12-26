//3. 가위 바위 보
import java.util.*;

class INT_03{

  public String solution(int rd, int[] A, int[] B){
    String answer = "";
    for(int i=0; i<rd; i++){
      if(A[i]==B[i]) answer+="D";
      else if (A[i]==1 && B[i]==3) answer+="A";
      else if (A[i]==2 && B[i]==1) answer+="A";
      else if (A[i]==3 && B[i]==2) answer+="A";
      else answer+="B";
    }
    return answer;
  }

  public static void main(String[] args){
    INT_03 T = new INT_03();
    Scanner sc = new Scanner(System.in);
    int round = sc.nextInt();
    int[] A = new int[100];
    int[] B = new int[100];
    for (int i = 0; i < round; i++){
      A[i] = sc.nextInt();
    }
    for (int j = 0; j < round; j++){
      B[j] = sc.nextInt();
    }
    for (char x : T.solution(round, A, B).toCharArray()){
      System.out.println(x);
    }
    return ;
  }
}