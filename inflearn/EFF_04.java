//4.연속 부분수열
import java.util.*;

public class EFF_04 {

    public int solution1(int n, int goal, int[] arr){
        int cnt = 0, sum = 0, k = 0;
        for (int i = 0; i < n; i++){
            sum = 0;
            k = i;
            while (sum < goal && k < n) sum += arr[k++];
            if (sum == goal){
                cnt++;
                if (k == n) return cnt;
                continue;
            } else if (k == n){
                return cnt;
            }
        }
        return cnt;
    }

    //강의 답
    public int solution2(int n, int goal, int[] arr){
        int cnt=0, sum=0, lt=0;
        for (int rt = 0; rt < n; rt++){
            sum += arr[rt];
            if(sum==goal) cnt++;
            while (sum>=goal){
                sum-=arr[lt++];
                if(sum==goal) cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        EFF_04 T = new EFF_04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int goal = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution1(n, goal, arr));
        sc.close();
    }
    
}
