//6. 뒤집은 소수
import java.util.*;

public class INT_06 {
    
    public boolean isPrime(int x){
        if (x <= 1) return false;
        for (int i = 2; i * i < x; i++){
            if (x % i == 0) return false;
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i<n; i++){
            int tmp = arr[i];
            int res = 0;
            while (tmp>0){
                int t = tmp%10;
                res = res * 10 + t;
                tmp = tmp/10;
            }
            if(isPrime(res)) ans.add(res);
        }
        return ans;
    }

    public static void main(String[] args){
        INT_06 T = new INT_06();
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for (int x: T.solution(n,arr)){
            System.out.print(x + " ");
        }
        sc.close();
        return ;
    }
}
