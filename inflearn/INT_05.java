import java.util.*;

class INT_05 {

    public int solution(int n){
        int cnt=0;
        int[] arr  = new int[n+1];
        for (int i = 2; i < n; i++){
            if (arr[i]==0){
                cnt++;
                for(int j = i; j <= n; j=j+i){
                    arr[j]=1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        INT_05 T = new INT_05();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
        sc.close();
        return ;
    }
}
