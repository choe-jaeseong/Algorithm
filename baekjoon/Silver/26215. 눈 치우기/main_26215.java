//26215. 눈 치우기
import java.util.*;

public class main_26215 {
    
    public int solution(int n, int[] arr){
        int ans = 0;
        Arrays.sort(arr);
        if (n == 1) return arr[0];
        int a = n - 2, b = n - 1;
        while(true){
            while(a>=0 && arr[a]==0) a--;
            while((b>=0 && arr[b]==0) || a==b) b--;
            if(a<0 && b<0) return ans;
            else if(a<0) return (ans + arr[b]);
            else if(b<0) return (ans + arr[a]);
            else{
                arr[a]--;
                arr[b]--;
                ans++;
            }
        }
    }

    public static void main(String[] args) {
        main_26215 T = new main_26215();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = T.solution(n, arr);
        if (ans>1440)
            System.out.println(-1);
        else
            System.out.println(ans);
        sc.close();
    }
}