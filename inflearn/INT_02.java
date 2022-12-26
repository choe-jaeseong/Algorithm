//2.보이는 학생
import java.util.*;

class INT_02{

  public int solution(int cnt, int[] student){
    int answer = 1;
    int max = student[0];
    for (int i = 1; i < cnt; i++){
      if (max < student[i]) {
        answer++;
        max = student[i];
      }
    }
    return answer;
  }
  
  public static void main(String[] args){
    INT_02 T = new INT_02();
    Scanner sc = new Scanner(System.in);
    int[] student = new int[100000];
    int cnt = sc.nextInt();
    for (int i = 0; i < cnt; i++){
      student[i] = sc.nextInt();
    }
    System.out.print(T.solution(cnt, student));
    sc.close();
    return ;
  }
}
