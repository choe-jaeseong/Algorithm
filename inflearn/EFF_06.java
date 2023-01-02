//6. 최대 길이 연속부분수열
import java.util.*;

public class EFF_06{
    //나의 답
    public int solution1(int n, int m, int[] arr){
        int ans = 0;
        for (int i=0; i<n; i++){
            int j = i, k = m, cnt = 0;
            while (j<n && k>=0) {
                if (arr[j]==1) {
                    cnt++; 
                    j++;  
                } else {
                    if (k == 0) break;
                    k--;
                    cnt++;
                    j++;
                }
            }
            if (ans < cnt) ans = cnt;
        }
        return ans;
    }

    //강의 답
    public int solution2(int n, int m, int[] arr){
        int ans = 0, cnt=0, lt=0;
        for (int rt=0; rt<n; rt++){
            if(arr[rt]==0) cnt++;
            while(cnt>m){
                if(arr[lt]==0) cnt--;
                lt++;
            }
            ans = Math.max(ans, rt-lt+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        EFF_06 T = new EFF_06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(T.solution1(n, m, arr));
        sc.close();
    }
}
