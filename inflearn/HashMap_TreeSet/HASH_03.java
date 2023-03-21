package HashMap;
//3. 매출액의 종류
import java.util.*;

public class HASH_03 {

    //나의 답  //Runtime Error
    public int[] solution1(int n, int k, int[] sale){
        int[] ans = new int[n-k+1];
        for(int i=0; i<n-k+1; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=i; j<i+4; j++){
                map.put(sale[j], map.getOrDefault(sale[j], 0)+1);
            }
            ans[i] = map.size();
        }
        return ans;
    }

    //강의 답
    public ArrayList<Integer> solution2(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k-1; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        int lt=0;
        for(int rt=k-1; rt<n; rt++){
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt])-1);
            if(map.get(arr[lt])==0) map.remove(arr[lt]);
            lt++;
        }
        return answer;
    }
    
    public static void main(String[] args) {
        HASH_03 T = new HASH_03();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] sale = new int[N];
        for (int i=0; i<N; i++){
            sale[i] = sc.nextInt();
        }
        for(int x : T.solution2(N, K, sale)){
            System.out.print(x + " ");
        }
        sc.close();
    }
}
