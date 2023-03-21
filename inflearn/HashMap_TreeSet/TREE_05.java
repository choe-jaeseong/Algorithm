package HashMap_TreeSet;
//5.k번째 큰 수
import java.util.*;

class TREE_05 {

  public int solution(int n, int k, int[] arr){
    int ans = -1;
    TreeSet<Integer> tset = new TreeSet<>(Collections.reverseOrder());
    for(int i=0; i<n; i++){
      for(int j=i+1; j<n; j++){
        for(int p=j+1; p<n; p++){
          tset.add(arr[i]+arr[j]+arr[p]);
        }
      }
    }
    int cnt=0;
    for(int x: tset){
      cnt++;
      if(cnt==k) return x;
    }
    return ans;
  }
  
  public static void main(String[] args) {
    TREE_05 T = new TREE_05();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }
    System.out.println(T.solution(n, k, arr));
    sc.close();
  }
}