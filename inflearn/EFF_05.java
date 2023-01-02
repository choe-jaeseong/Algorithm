//5. 연속된 자연수의 합
import java.util.*;

public class EFF_05 {

    public int solution(int N){
        int ans=0;
        for (int i = N/2+1; i > 0; i--){
            int sum = 0;
            int j = i;
            while (sum < N) sum+=j--;
            if (sum == N) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        EFF_05 T = new EFF_05();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(T.solution(N));
        sc.close();
    }
}
