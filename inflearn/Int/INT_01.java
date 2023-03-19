package Int;
//강의 답
import java.util.*;

class Main{

  public ArrayList<Integer> solution(int cnt, int[] arr){
    ArrayList<Integer> answer = new ArrayList<>();
		answer.add(arr[0]);
		for (int i = 1; i < cnt; i++){
			if (arr[i] > arr[i-1]) answer.add(arr[i]);
		}
		return answer;
  }

  public static void main(String[] args){
    Main T = new Main();
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
		int[] arr= new int[cnt]; //동적 할당
    for (int i=0; i < cnt; i++){
      arr[i] = sc.nextInt();
    }
    for (int x : T.solution(cnt, arr)){
			System.out.print(x+" ");
		}
    sc.close();
    return ;
  }
}

/*
//나의 답
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
*/