// 8. 등수구하기
import java.util.*;

public class INT_08 {
    
    public int[] solution(int n, int[] score){
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            ans[i]=1;
            for (int j = 0; j < n; j++){
                if (score[i]<score[j]) ans[i]++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        INT_08 T = new INT_08();
        Scanner sc = new Scanner(System.in);
        int[] score = new int[100];
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            score[i]=sc.nextInt();
        }
        for(int x: T.solution(n, score)){
            System.out.print(x+" ");
        }
        sc.close();
        return ;
    }
}
